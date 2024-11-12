package com.example.roxiler.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()  // Disable CSRF for simplicity (enable it if required)
                .authorizeRequests()
                .anyRequest().permitAll()  // Allow all requests
                .and()
                .headers().frameOptions().disable(); // Optional: Disable frame options if using H2 console

        return http.build();
    }
}
