package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for simplicity in testing Swagger
                .csrf(csrf -> csrf.disable())
                // Define which endpoints are allowed publicly
                .authorizeHttpRequests(auth -> auth
                        // Swagger endpoints
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html"
                        ).permitAll()
                        // Authentication endpoints
                        .requestMatchers("/auth/**").permitAll()
                        // Everything else requires authentication
                        .anyRequest().authenticated()
                )
                // Optional: form login for other secured endpoints
                .formLogin(withDefaults -> {});

        return http.build();
    }
}
