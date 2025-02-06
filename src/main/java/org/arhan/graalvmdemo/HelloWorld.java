package org.arhan.graalvmdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloWorld {

    static LocalDateTime now = LocalDateTime.now();

    @GetMapping("/")
    public String hello() {
        return "Hello World! " + now;
    }
}
