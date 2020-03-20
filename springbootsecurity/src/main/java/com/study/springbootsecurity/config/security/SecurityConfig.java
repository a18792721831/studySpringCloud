package com.study.springbootsecurity.config.security;

import com.study.springbootsecurity.beans.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author jiayq
 * @Date 2020-03-17
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private Environment environment;

    @Value("${web.security.user.name}")
    private String username;

    @Value("${web.security.user.pswd}")
    private String password;

    @Value("${web.security.user.role}")
    private String role;

    @Value("${web.security.admin.name}")
    private String adminName;

    @Value("${web.security.admin.pswd}")
    private String adminPswd;

    @Value("${web.security.admin.role}")
    private String adminRole;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser(username).password("{noop}" + password)
                .roles(role.split(","));
        auth.inMemoryAuthentication().withUser(adminName).password("{noop}" + adminPswd)
                .roles(adminRole.split(","));
        Student student = Student.getBuild().name("小美").age(23).like("足球");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**", "/index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and()
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                .exceptionHandling().accessDeniedPage("/401")
                .and()
                .logout().logoutSuccessUrl("/");
    }

}
