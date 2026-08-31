package com.example.demoapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

  @Value("${team.coach.name}")
  private String coachName;
  @Value("${team.name}")
  private String teamName;

  @GetMapping("/")
  public String sayHello() {
    return "Hello, world!";
  }

  @GetMapping("/teamInfo")
  public String getTeamInfo() {
    return "Team: " + teamName + ". Coach: " + coachName;
  }

}
