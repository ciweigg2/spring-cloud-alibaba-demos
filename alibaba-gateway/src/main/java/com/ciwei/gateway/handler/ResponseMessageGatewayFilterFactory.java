package com.ciwei.gateway.handler;

import com.ciwei.common.utils.ResponseMessage;
import com.ciwei.gateway.mapstruct.ResponseEntity;
import com.ciwei.gateway.mapstruct.ResponseMessageMapper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.rewrite.ModifyResponseBodyGatewayFilterFactory;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 应用返回格式统一处理(success faield 两种格式处理)
 * yml中配置的filter名字，加GatewayFilterFactory,就是对应的过滤器Java类
 * yml中配置了当前为默认的过滤器为了做统一处理 也可以一个路由对应一个过滤规则
 *
 * @NAME ResponseMessageGatewayFilterFactory
 * @USER Ciwei
 * @DATE 2019/9/2 20:29
 **/
@Component
public class ResponseMessageGatewayFilterFactory extends ModifyResponseBodyGatewayFilterFactory {

    @Autowired
    private ResponseMessageMapper responseMessageMapper;

    @Override
    public GatewayFilter apply(Config config) {
        return new ModifyResponseGatewayFilter(this.getConfig());
    }

    private Config getConfig() {
        Config cf = new Config();
        // Config.setRewriteFunction(Class<T> inClass, Class<R> outClass, RewriteFunction<T, R> rewriteFunction)
        // inClass 原数据类型，可以指定为具体数据类型，我这里指定为Object,是为了处理多种数据类型。
        // 当然支持多接口返回多数据类型的统一修改，yaml中的配置，path,uri需要做相关调整
        // outClass 目标数据类型
        // rewriteFunction 内容重写方法
        cf.setRewriteFunction(Object.class, ResponseMessage.class, getRewriteFunction());
        return cf;
    }

    private RewriteFunction<Object, ResponseMessage> getRewriteFunction() {
        return (exchange, resp) -> {
            ResponseEntity responseEntity = new ResponseEntity();
            try {
                //将返回的map转成对象
                BeanUtils.populate(responseEntity, (Map<String, ? extends Object>) resp);
            } catch (Exception e) {
                //如果类型转换错误设置默认值
                responseEntity.setStatus(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
                responseEntity.setError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
                responseEntity.setMessage(e.getMessage());
            }
            //使用mapstruct转换dto返回
            ResponseMessage responseMessage = responseMessageMapper.responseEntityToResponseMessage(responseEntity);
            if (responseMessage.getData() == null) {
                responseMessage.setMessage("failed");
                responseMessage.setData(responseEntity.getMessage());
            }
            return Mono.just(responseMessage);
        };

    }

}
