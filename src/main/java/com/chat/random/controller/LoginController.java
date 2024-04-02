package com.chat.random.controller;

import com.chat.random.service.MobilecodeAuthenticationToken;
import jakarta.annotation.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.ServerException;
import java.util.UUID;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/2 21:07:56
 */
@RestController
public class LoginController {

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 用户名密码登录
     * @param username 用户名
     * @param password 密码
     * @return 返回登录结果
     */
    @GetMapping("/usernamePwd")
    public Result<?> usernamePwd(String username, String password) throws ServerException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        try {
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException | UsernameNotFoundException e) {
            throw new ServerException(e.getMessage());
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        return Result.ok(token);
    }

    /**
     * 手机验证码登录
     * @param phone 手机号
     * @param mobileCode 验证码
     * @return 返回登录结果
     */
    @GetMapping("/mobileCode")
    public Result<?> mobileCode(String phone, String mobileCode) {
        MobilecodeAuthenticationToken mobilecodeAuthenticationToken = new MobilecodeAuthenticationToken(phone, mobileCode);
        Authentication authenticate;
        try {
            authenticate = authenticationManager.authenticate(mobilecodeAuthenticationToken);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("验证码错误");
        }
        System.out.println(authenticate);
        String token = UUID.randomUUID().toString().replace("-", "");
        return Result.ok(token);
    }

    @GetMapping("demo")
    @PreAuthorize("hasAuthority('xxl-job')")
    public String demo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("authentication = " + authentication);
        return "hello world";
    }


}
