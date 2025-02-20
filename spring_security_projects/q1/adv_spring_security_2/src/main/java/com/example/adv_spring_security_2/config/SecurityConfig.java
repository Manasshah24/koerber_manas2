package com.example.adv_spring_security_2.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // Enable method-level security
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers("/books/**").authenticated() // Secure all book endpoints
                .anyRequest().permitAll()
                .and()
                .httpBasic(); // Use Basic Authentication
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails student = User.builder()
                .username("student")
                .password(passwordEncoder().encode("student123"))
                .roles("STUDENT")
                .build();

        UserDetails teacher = User.builder()
                .username("teacher")
                .password(passwordEncoder().encode("teacher123"))
                .roles("TEACHER")
                .build();

        return new InMemoryUserDetailsManager(student, teacher);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
