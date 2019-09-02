package com.ciwei.common.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @NAME CommonResult
 * @USER Ciwei
 * @DATE 2019/8/25/025 18:44
 **/
@Data
public final class ResponseMessage<T> implements Serializable {

    /**
     * 状态码
     */
    private String status;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 数据
     */
    public T data;

    private static final String STATUS_SUCCESS = "200";

    private static final String STATUS_FAIL = "500";

    private static final String MESSAGE_SUCCESS = "success";

    private static final String MESSAGE_FAIL = "failed";

    public ResponseMessage() {
    }

    public ResponseMessage(String status) {
        this.status = status;
    }

    public ResponseMessage(String status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ResponseMessage(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResponseMessage success() {
        return new ResponseMessage(STATUS_SUCCESS, MESSAGE_SUCCESS);
    }

    public static ResponseMessage success(Object data) {
        return new ResponseMessage(STATUS_SUCCESS, MESSAGE_SUCCESS, data);
    }

    public static ResponseMessage fail() {
        return new ResponseMessage(STATUS_FAIL, MESSAGE_FAIL);
    }

    public static ResponseMessage fail(String status ,Object data) {
        return new ResponseMessage(status ,MESSAGE_FAIL ,data);
    }

}
