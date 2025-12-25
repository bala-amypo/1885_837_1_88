package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF to avoid 401/403
            .csrf(csrf -> csrf.disable())

            // Allow all requests (IMPORTANT for tests & Swagger)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/hello-servlet",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/**"
                ).permitAll()
            );

        return http.build();
    }

    // Required by UserServiceImpl
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
