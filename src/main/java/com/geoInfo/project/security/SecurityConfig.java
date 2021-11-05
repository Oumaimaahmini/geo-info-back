package com.geoInfo.project.security;

import com.geoInfo.project.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService myUserDetailsService;
    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint ;

    @Autowired
     JwtRequestFilter jwtRequestFilter;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("configureGlobal called");
        auth.userDetailsService(myUserDetailsService);
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPointBean() throws Exception {
        return new AuthenticationEntryPoint();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }




    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().disable();
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate").permitAll()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .antMatchers("/intermediaires").hasRole("ADMIN")
                .antMatchers("/hello").hasAnyRole("ADMIN","INTER")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }



}
