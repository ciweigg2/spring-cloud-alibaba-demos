package com.ciwei.gift.exception;

import com.alibaba.fastjson.JSONObject;
import com.ciwei.common.utils.BusinessException;
import com.ciwei.common.utils.ResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * 获取feign原始的异常
 *
 * @NAME ExceptionErrorDecoder
 * @USER Ciwei
 * @DATE 2019/8/26/026 16:38
 **/
@Slf4j
@Configuration
public class ExceptionErrorDecoder implements ErrorDecoder {

    public Exception decode(String methodKey, Response response) {
        ObjectMapper om = new ObjectMapper();
        JSONObject jsonObject;
        try {
            jsonObject = om.readValue(Util.toString(response.body().asReader()), JSONObject.class);
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return new RuntimeException(jsonObject.getString("message"));
    }

}
