package com.spring.security.cofig;

import com.spring.security.auth.JwtAuthenticationEntryPoint;
import com.spring.security.auth.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private JwtAuthenticationFilter filter;

    private JwtAuthenticationEntryPoint point;

    public SecurityConfig(JwtAuthenticationFilter filter,JwtAuthenticationEntryPoint point){
        this.filter= filter;
        this.point = point;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable()).authorizeHttpRequests(auth -> auth.requestMatchers("/user/**").authenticated().requestMatchers("/auth/login").permitAll().anyRequest().authenticated()).exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
          return builder.getAuthenticationManager();
    }
}
