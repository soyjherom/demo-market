package com.example.demomarket.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greetings")
public class HelloWorldController {
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
