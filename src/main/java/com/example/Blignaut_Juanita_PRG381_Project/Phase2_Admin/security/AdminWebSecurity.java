package com.example.Blignaut_Juanita_PRG381_Project.Phase2_Admin.security;
import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Blignaut_Juanita_PRG381_Project.Phase2_Admin.services.CustomAdminDetailsService;

public class AdminWebSecurity extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomAdminDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder pwEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(pwEncoder());

        return authProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
             .antMatchers("/adminstudents").authenticated()
             .anyRequest().permitAll()
             .and()
             .formLogin()
             .usernameParameter("email")
             .defaultSuccessUrl("/adminstudents")
             .permitAll()
             .and()
             .logout().logoutSuccessUrl("/").permitAll();
    }
}
