package com.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import static org.springframework.security.core.userdetails.User.*;

@Configuration
@EnableWebSecurity
public class DemoSercurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

            //add our users for in memory atuhentication

        UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("john").password("test123").roles("EMPLOYEE"))
                .withUser(users.username("mary").password("test123").roles("EMPLOYEE","MANAGER"))
                .withUser(users.username("susan").password("test123").roles("EMPLOYEE","ADMIN"));
    }

    protected void configure(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeRequests()

                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .antMatchers("/").hasRole("EMPLOYEE")

                .and()
                .formLogin()
                .loginPage("/showMyLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
                .and()
                .logout().permitAll()
            .and()
        .exceptionHandling().accessDeniedPage("/access-denied");

    }

}
