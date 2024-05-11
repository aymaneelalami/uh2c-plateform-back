package com.uh2plateform.core;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
  @GetMapping("/hello")
  public String home() {
    return "hello world";
  }
}