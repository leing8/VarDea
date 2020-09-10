package com.vardea.blog.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Var Dea
 * @date 2020/8/3 21:50
 * 制定spring 安全的密码编码原则
 */
@Component
public class PasswordEncoderConfig implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}