package com.ciwei.gateway.mapstruct;

import com.ciwei.common.utils.ResponseMessage;
import org.mapstruct.*;

/**
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
	ResponseMessage responseEntityToResponseMessage(ResponseEntity responseEntity);

}
