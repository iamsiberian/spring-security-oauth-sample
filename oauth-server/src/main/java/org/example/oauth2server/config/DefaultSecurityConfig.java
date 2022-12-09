package org.example.oauth2server.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class DefaultSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
          authorizeRequests.anyRequest().authenticated()
        )
          .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    UserDetailsService users(
            @Value("${defaultUser.name}") String defaultUserName,
            @Value("${defaultUser.password}") String defaultUserPassword,
            @Value("${defaultUser.role}") String defaultUserRole
    ) {
        UserDetails user = User.withDefaultPasswordEncoder()
          .username(defaultUserName)
          .password(defaultUserPassword)
          .roles(defaultUserRole)
          .build();
        return new InMemoryUserDetailsManager(user);
    }

}
