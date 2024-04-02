package com.chat.random.model;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2023/12/7 13:53
 */
public enum RequestStatus {
    /**
     * 请求状态
     */
    SUCCESS(200, "success"),
    FAIl(500,"fail");

    RequestStatus(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    private final Integer code;

    private final String value;

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
