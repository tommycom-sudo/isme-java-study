package com.example.demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.R;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@Slf4j
@RestController
@RequestMapping("/auth")
public class LoggerTest {
    //private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test1(){


        log.info("start...");
        Object a,b;
        a = register();
        //b = loginTest();
        throw new BizException(TestResponseCode.ERR_30001);
    }
    private LoginTokenDto generateToken() {
        // 密码验证成功

        LoginTokenDto dto = new LoginTokenDto();
        dto.setAccessToken("test token");
        return dto;
    }
    private LoginTokenDto login() {
        boolean checkPw = true;//BCrypt.checkpw(request.getPassword(), user.getPassword());
        if (checkPw) {
            return generateToken();
        } else {
            throw new BizException(TestResponseCode.ERR_30001);
        }
    }
    private static final String CAPTCHA_KEY = "captchaKey";

    @PostMapping("/login")
    public R<LoginTokenDto> loginTest(@RequestBody final LoginRequest request,
                                      HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        String captchaKey = (String) session.getAttribute(CAPTCHA_KEY);
        if (captchaKey != null) {
            request.setCaptchaKey(captchaKey);
        }
        LoginTokenDto tokenDto = login();
        return  R.ok(tokenDto);
    }
    public R<Void> register() {

        return R.ok();
    }

}
