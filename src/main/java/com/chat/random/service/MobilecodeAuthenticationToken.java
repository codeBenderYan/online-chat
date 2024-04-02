package com.chat.random.service;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author YanJiaJun
 * @version 1.0
 * @date 2024/4/2 21:01:27
 */
public class MobilecodeAuthenticationToken  extends AbstractAuthenticationToken {

    private static final long serialVersionUID = 530L;
    private Object principal;
    private Object credentials;
    private String phone;
    private String mobileCode;


    public MobilecodeAuthenticationToken(String phone, String mobileCode) {
        super(null);
        this.phone = phone;
        this.mobileCode = mobileCode;
        this.setAuthenticated(false);
    }

    public MobilecodeAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.credentials = credentials;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return this.credentials;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobileCode() {
        return mobileCode;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    @Override
    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }

}
