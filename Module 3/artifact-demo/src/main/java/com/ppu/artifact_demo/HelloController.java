package com.ppu.artifact_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Endpoint for static welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Spring Boot!";
    }

    // Endpoint for dynamic greeting message with a query parameter 'name'
    @GetMapping("/greet")
    public String greet(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "Hello, " + name + "!";
    }
}
