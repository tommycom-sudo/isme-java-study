package com.example.demo;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//@Getter
//@RequiredArgsConstructor
public enum TestResponseCode {
    OK(0, "OK"),
    ERR_30001(30001, "预览环境不支持此操作");
    private final int code;

    private final String msg;

    private TestResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}


