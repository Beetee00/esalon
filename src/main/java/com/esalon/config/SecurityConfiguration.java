package com.esalon.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @noinspection ALL
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/api/salon/auth/**",
                        "/api/salon/appointments/**",
                        "/api/esalon/apps/**",
                        "/api/esalon/feedback/**",
                        "/api/esalon/customers/**",
                        "/api/esalon/users/**",
                        "/api/esalon/stock/**",
                        "/api/esalon/salon/**",
                        "/api-docs/**",
                        "/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/configuration/**",
                        "/swagger-ui/**"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
