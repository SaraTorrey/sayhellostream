package com.sayhellostream.sayhellostream;


import com.sayhellostream.sayhellostream.service.AppUserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AppUserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth ) throws Exception {

        auth.userDetailsService( userDetailsService )
                .passwordEncoder( new BCryptPasswordEncoder() );
    }

    @Override
    @Order( 1 )
    protected void configure( HttpSecurity httpSecurity ) throws Exception {

        String[] authorizedEndpoints = { "/css/**",
                                         "/fontds.nucleo/**",
                                         "/images/**",
                                         "/img/**",
                                         "/js/**",
                                         "/scss/**",
                                         "/vendor/**"
        };
        httpSecurity.authorizeRequests()
                .antMatchers( authorizedEndpoints ).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage( "/login" ).defaultSuccessUrl( "/" )
                .permitAll()
                .and()
                .logout()
                .permitAll();

        httpSecurity.csrf().disable();
    }
}
