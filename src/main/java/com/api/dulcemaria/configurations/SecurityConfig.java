package com.api.dulcemaria.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // Deshabilita CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // Permite todas las solicitudes sin autenticación
                );
        return http.build();
    }
}
