package ru.creditcalc.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/", "/error", "/favicon.ico").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().permitAll())
                .csrf(csrf -> csrf
                        .csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                        .ignoringRequestMatchers(antMatcher("/api/**")))
                .sessionManagement(sessionManagement -> sessionManagement
                        .maximumSessions(1))
                .build();
    }

    @Bean
    public TomcatConnectorCustomizer tomcatConnectorCustomizer() {
        return connector -> connector.setParseBodyMethods("POST,PATCH,PUT,DELETE");
    }

}
