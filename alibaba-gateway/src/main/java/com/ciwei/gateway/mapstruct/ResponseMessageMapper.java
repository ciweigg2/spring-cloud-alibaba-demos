package com.ciwei.gateway.mapstruct;

import com.ciwei.common.utils.ResponseMessage;
import org.mapstruct.*;

/**
 * restful统一响应格式
 *
 * @NAME ResponseMessageMapper
 * @USER Ciwei
 * @DATE 2019/9/2 20:53
 **/
@Mapper(componentModel = "spring")
public interface ResponseMessageMapper {

	@Mappings(value = {
			@Mapping(source = "data", target = "data"),
			@Mapping(source = "status", target = "status"),
			@Mapping(source = "message", target = "message"),
	})
	ResponseMessage responseEntityToResponseMessage(ResponseEntity responseEntity ,@MappingTarget ResponseMessage responseMessage);

	@AfterMapping
	default void setResponseEntityToResponseMessage(ResponseEntity responseEntity ,@MappingTarget ResponseMessage responseMessage){
		//处理报错返回
		if (responseMessage.getData() == null) {
			responseMessage.setMessage("failed");
			responseMessage.setData(responseEntity.getMessage());
		}
	}

}
