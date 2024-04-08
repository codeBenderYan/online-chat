package com.platform.chaotic.controller;

import com.platform.chaotic.model.dto.UserLoginDTO;
import com.platform.chaotic.model.dto.UserLoginDetails;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/8 16:53
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserLoginController {

    @Resource
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO userLoginDTO){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        UserLoginDetails loginDetails = (UserLoginDetails)authenticate.getPrincipal();
        System.out.println(loginDetails);
        return "success";
    }
}
