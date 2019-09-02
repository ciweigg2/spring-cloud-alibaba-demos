package com.ciwei.gateway.mapstruct;

import lombok.Data;

import java.io.Serializable;

/**
 * @NAME Response
 * @USER Ciwei
 * @DATE 2019/9/2 21:16
 **/
@Data
public class ResponseEntity<T> implements Serializable {

	private String status;

	private String message;

	private String error;

	private String path;

	private T data;

}
