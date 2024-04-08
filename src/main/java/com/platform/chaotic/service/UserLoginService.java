package com.platform.chaotic.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.platform.chaotic.mapper.UserInfoMapper;
import com.platform.chaotic.model.dto.UserLoginDetails;
import com.platform.chaotic.model.po.UserInfoDO;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/8 15:58
 */
@Service
public class UserLoginService implements UserDetailsService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfoDO user = userInfoMapper.selectOne(new QueryWrapper<UserInfoDO>().eq("user_name", username));
        if (Objects.isNull(user)){
            throw new UsernameNotFoundException("用户不存在，请您先注册后登录！");
        }
        return new UserLoginDetails(user);
    }
}
