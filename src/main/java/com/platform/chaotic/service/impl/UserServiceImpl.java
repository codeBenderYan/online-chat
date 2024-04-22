package com.platform.chaotic.service.impl;

import com.platform.chaotic.exception.BusinessException;
import com.platform.chaotic.model.dto.UserRegisterDTO;
import com.platform.chaotic.service.UserService;
import com.platform.chaotic.util.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/22 22:58:29
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String registerUser(UserRegisterDTO userRegisterDTO) {
        if (!StringUtils.equals(userRegisterDTO.getPassword(), userRegisterDTO.getPasswordConfirm())) {
            throw new BusinessException("两次密码输入不一致");
        }
        return JwtUtil.generateToken(userRegisterDTO.getUsername());
    }

}
