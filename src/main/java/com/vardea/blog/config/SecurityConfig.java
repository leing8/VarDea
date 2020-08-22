package com.vardea.blog.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Var Dea
 * @date 2020/8/3 17:34
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/manage/**").hasAnyRole()
                .antMatchers("/**").permitAll()
                //.antMatchers("/level1/**").hasAnyAuthority("VIP1")
                //.antMatchers("/level2/**").hasAnyAuthority("VIP2")
                //.antMatchers("/level3/**").hasAnyAuthority("VIP3")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                //.loginPage("/userlogin")
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and().
                rememberMe()
                .rememberMeParameter("remember")
                .userDetailsService(new SecurityUserDetailServiceConfig());
    }
}
