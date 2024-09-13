package com.techlabs.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.techlabs.demo.security.CustomerUserDetailsService;
import com.techlabs.demo.security.JwtAuthenticationEntryPoint;
import com.techlabs.demo.security.JwtAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomerUserDetailsService userDetailsService = null;
    private final JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
    private final JwtAuthenticationEntryPoint authenticationEntryPoint = new JwtAuthenticationEntryPoint();

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(request -> request
                .requestMatchers("/api/register").authenticated()
                .requestMatchers("/api/login").permitAll()
                .requestMatchers(HttpMethod.GET, "/bankapp/**").authenticated()
                .requestMatchers(HttpMethod.POST, "/bankapp/**").authenticated()
                .requestMatchers(HttpMethod.PUT, "/bankapp/**").authenticated()
                .requestMatchers(HttpMethod.DELETE, "/bankapp/**").authenticated()
                .anyRequest().authenticated())
            .exceptionHandling(exception -> exception.authenticationEntryPoint(authenticationEntryPoint));
         

        return http.build();
    }

	private Object withDefaults() {
		// TODO Auto-generated method stub
		return null;
	}
}
