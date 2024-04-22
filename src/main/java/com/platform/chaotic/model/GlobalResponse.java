package com.platform.chaotic.model;

import lombok.Data;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/22 22:51:02
 */
@Data
public class GlobalResponse<T> {

    private Integer code;

    private String message;

    private T data;

    public GlobalResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static GlobalResponse<Object> ok(Object data) {
        return new GlobalResponse<>(200, data);
    }
}
