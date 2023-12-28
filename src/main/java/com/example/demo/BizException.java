package com.example.demo;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException {

    private final TestResponseCode code;

    public BizException(TestResponseCode bizResponseCode) {
        super(bizResponseCode.getMsg());
        this.code = bizResponseCode;
    }

    public BizException(TestResponseCode bizResponseCode, String msg) {
        super(msg);
        this.code = bizResponseCode;
    }

}