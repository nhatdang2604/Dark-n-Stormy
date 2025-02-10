package com.nhatdang2604.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hello")
public class HelloWorldController {

    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }
}
