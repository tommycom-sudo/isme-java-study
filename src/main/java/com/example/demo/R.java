package com.example.demo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class R<T> {
    /**
     * 数据
     */
    private T data;

    /**
     * 响应码
     */
    private int code;

    public static <T> R<T> ok() {
        return ok(null);
    }

    /**
     * 描述
     */
    private String message;
    public static <T> R<T> ok(T data) {
        R<T> r = new R<>();
        r.setData(data);
        r.setCode(TestResponseCode.OK.getCode());
        r.setMessage(TestResponseCode.OK.getMsg());
        return r;
    }
}