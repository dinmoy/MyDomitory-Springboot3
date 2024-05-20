package com.jin.MyDomitory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(withDefaults());
        http
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/user/**").permitAll()
                        .requestMatchers("/board/**").permitAll()
                        .requestMatchers("/laundry/**").permitAll()
                        .requestMatchers("/personal/**").permitAll()
                        .requestMatchers("/public/**").permitAll()


                        .anyRequest().authenticated()
                )
                .logout(withDefaults());
        return http.build();
    }
}