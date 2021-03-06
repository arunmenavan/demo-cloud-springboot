package com.ais.clouddemo.webapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	//Create User - demouser/demo
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("demo user").password("demo")
                .roles("USER", "ADMIN");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.requiresChannel().anyRequest().requiresSecure();
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/", "/pro*/**","/sho*/**").access("hasRole('USER')").and()
                .formLogin();
    }
}
