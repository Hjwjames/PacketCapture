package com.example.HjwJames.helloworld.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloWorld")
public class HelloWorldController {
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String hello(){
        return "Hello world!";
    }
}
