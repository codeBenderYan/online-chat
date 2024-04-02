package com.chat.random.model;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2023/11/28 23:15:54
 * @description Global Response Class
 */
public class GlobalResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -2112285017993367870L;

    private Integer code;

    private String message;

    private T data;

    public GlobalResponse(Integer code) {
        this.code = code;
    }

    public GlobalResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public GlobalResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public GlobalResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static GlobalResponse<Object> ok() {
        return new GlobalResponse<>(RequestStatus.SUCCESS.getCode());
    }

    public static GlobalResponse<Object> ok(String message) {
        return new GlobalResponse<>(RequestStatus.SUCCESS.getCode(), message);
    }

    public static GlobalResponse<Object> success(Object data) {
        return new GlobalResponse<>(RequestStatus.SUCCESS.getCode(), data);
    }

    public static GlobalResponse<Object> success(String message, Object data) {
        return new GlobalResponse<>(RequestStatus.SUCCESS.getCode(), message, data);
    }

    public static GlobalResponse<Object> fail(String message) {
        return new GlobalResponse<>(RequestStatus.FAIl.getCode(), message);
    }

    public static GlobalResponse<Object> fail(int code, String message) {
        return new GlobalResponse<>(code, message);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
