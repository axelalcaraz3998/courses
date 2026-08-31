package com.example.demoapp.rest;

import com.example.demoapp.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

  private Coach coach;

  @Autowired
  public MyRestController(Coach coach) {
    System.out.println("In constructor: " + getClass().getSimpleName());

    this.coach = coach;
  }

  @GetMapping("/dailyworkout")
  public String getDailyWorkout() {
    return coach.getDailyWorkout();
  }

}
