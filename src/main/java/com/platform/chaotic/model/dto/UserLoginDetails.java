package com.platform.chaotic.model.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.platform.chaotic.model.po.UserInfoDO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/8 16:44
 */
@Data
public class UserLoginDetails implements UserDetails {
    private String userId;

    private String userName;

    private String password;

    public UserLoginDetails(UserInfoDO userInfoDO) {
        this.userId = userInfoDO.getUserId();
        this.userName = userInfoDO.getUserName();
        this.password = userInfoDO.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
