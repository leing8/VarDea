package com.vardea.blog.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Var Dea
 * @date 2020/8/3 20:11
 */
@Component
public class SecurityUserDetailServiceConfig implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查找用户信息
        if (!"1".equals(username)) {
            throw new RuntimeException("账号错误");
        }
        //List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("VIP1,VIP2");
        //return new User("1", new MyPasswordEncoder().encode("11"), authorities);
        return new User("1", new PasswordEncoderConfig().encode("11"), null);
    }
}
