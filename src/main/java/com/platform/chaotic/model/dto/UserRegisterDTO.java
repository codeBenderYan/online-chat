package com.platform.chaotic.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/22 22:57:12
 */
@Data
public class UserRegisterDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;


    @NotBlank(message = "用户名不可以为空!")
    @Length(min = 3, max = 30, message = "用户名长度错误，最短为3位，最长为30位")
    private String username;

    @NotBlank(message = "用户密码不可以为空!")
    @Length(min = 8, max = 32, message = "密码长度错误，最短为8位，最长位32位!")
    private String password;

    @NotBlank(message = "确认密码不可以为空!")
    @Length(min = 8, max = 32, message = "密码长度错误，最短为8位，最长位32位!")
    private String passwordConfirm;
}
