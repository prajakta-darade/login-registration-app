package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // Disable CSRF for testing (or handle properly)
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/register", "/login", "/logout", "/dashboard", "/search","/users")
								.permitAll().anyRequest().authenticated())
				.logout(logout -> logout.logoutUrl("/logout") // Default is POST /logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")) // Allow GET logout
						.permitAll())
				.formLogin(login -> login.disable()).httpBasic().disable();

		return http.build();
	}

}