package com.example.demo;

import lombok.Data;

@Data
public class LoginTokenDto {

    /**
     * 通过登录获取的token
     */
    private String accessToken;

}
