package com.platform.chaotic.service;

import com.platform.chaotic.model.dto.UserRegisterDTO;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/22 22:58:29
 */
public interface UserService {

    /**
     * 用户注册
     *
     * @param userRegisterDTO 用户注册信息
     * @return token
     */
    String registerUser(UserRegisterDTO userRegisterDTO);

}
