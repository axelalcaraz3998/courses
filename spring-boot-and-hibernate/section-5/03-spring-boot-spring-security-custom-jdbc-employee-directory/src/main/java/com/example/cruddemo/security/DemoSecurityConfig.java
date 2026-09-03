package com.example.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

  @Bean
  public UserDetailsManager userDetailsManager(DataSource dataSource) {
    JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

    jdbcUserDetailsManager
        .setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
    jdbcUserDetailsManager
        .setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

    return jdbcUserDetailsManager;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests((configurer) -> {
      configurer
          .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
          .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
          .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
          .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
          .requestMatchers(HttpMethod.PATCH, "/api/employees/**").hasRole("MANAGER")
          .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN");
    });

    // Use HTTP basic authentication
    httpSecurity.httpBasic(Customizer.withDefaults());
    // Disable CSRF
    httpSecurity.csrf((csrf) -> csrf.disable());

    return httpSecurity.build();
  }

}
