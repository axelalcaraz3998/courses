package com.example.demoapp.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements Coach {

  @PostConstruct
  public void startup() {
    System.out.println("In startup(): " + getClass().getSimpleName());
  }

  @PreDestroy
  public void cleanup() {
    System.out.println("In cleanup(): " + getClass().getSimpleName());
  }

  @Override
  public String getDailyWorkout() {
    return "Practice your backhand volley.";
  }

}
