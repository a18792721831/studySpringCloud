package com.study.springbootadminserversecurity.config.security;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import io.netty.handler.codec.http.HttpMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.UUID;

/**
 * @author jiayq
 * @Date 2020-03-15
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${admin.login.user.name}")
    private String userName;

    @Value("${admin.login.user.pswd}")
    private String password;

    @Value("${admin.login.user.role}")
    private String role;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setDefaultTargetUrl("/");

        http.authorizeRequests()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").successHandler(successHandler).and()
                .logout().logoutUrl("/logout").and()
                .httpBasic().and()
                .csrf()
                .disable()
                .rememberMe().key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(userName).password("{noop}"+password).roles(role);
    }

}
