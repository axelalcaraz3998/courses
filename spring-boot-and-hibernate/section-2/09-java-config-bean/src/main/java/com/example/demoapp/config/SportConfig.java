package com.example.demoapp.config;

import com.example.demoapp.common.Coach;
import com.example.demoapp.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

  @Bean
  public Coach swimCoach() {
    return new SwimCoach();
  }

}
