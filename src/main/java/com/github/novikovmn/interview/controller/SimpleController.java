package com.github.novikovmn.interview.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rest")
public class SimpleController {

    // app/rest - GET
    @GetMapping()
    public String get(@RequestParam(value = "message") String message) {
        return "GET: " + message;
    }

    // app/rest - POST
    @PostMapping()
    public String post(@RequestParam(value = "message") String message, @RequestParam(value = "number") int number) {
        return "POST: message: " + message + ", number: " + number;
    }
}
