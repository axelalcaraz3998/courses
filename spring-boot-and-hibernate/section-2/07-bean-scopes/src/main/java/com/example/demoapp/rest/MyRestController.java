package com.example.demoapp.rest;

import com.example.demoapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

  private Coach coach;
  private Coach anotherCoach;

  @Autowired
  public MyRestController(Coach coach, Coach anotherCoach) {
    this.coach = coach;
    this.anotherCoach = anotherCoach;
  }

  @GetMapping("/dailyworkout")
  public String getDailyWorkout() {
    return coach.getDailyWorkout();
  }

  @GetMapping("/checkbeans")
  public String checkBeans() {
    return "Comparing beans: coach == anotherCoach: " + (coach == anotherCoach);
  }

}
