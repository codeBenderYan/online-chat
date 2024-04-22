package com.platform.chaotic.controller;

import com.platform.chaotic.model.GlobalResponse;
import com.platform.chaotic.model.dto.UserLoginDTO;
import com.platform.chaotic.model.dto.UserLoginDetails;
import com.platform.chaotic.model.dto.UserRegisterDTO;
import com.platform.chaotic.service.UserService;
import com.platform.chaotic.util.JwtUtil;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/8 16:53
 */
@Tag(name = "用户接口")
@RestController
@RequestMapping("/api/v1/user")
public class UserLoginController {

    @Resource
    private UserService userService;

    @Resource
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public GlobalResponse<Object> login(@RequestBody UserLoginDTO userLoginDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        UserLoginDetails loginDetails = (UserLoginDetails) authenticate.getPrincipal();
        String token = JwtUtil.generateToken(loginDetails.getUsername());
        return GlobalResponse.ok(token);
    }

    @PostMapping("/register")
    public GlobalResponse<Object> register(@Validated @RequestBody UserRegisterDTO userRegisterDTO) {
        String token = userService.registerUser(userRegisterDTO);
        return GlobalResponse.ok(token);
    }

}
