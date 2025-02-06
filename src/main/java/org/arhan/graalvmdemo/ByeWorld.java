package org.arhan.graalvmdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;
import java.time.LocalDateTime;

@RestController
public class ByeWorld {

    static LocalDateTime now = LocalDateTime.now();
    private PrintStream out;

    @GetMapping("/bye")
    public String hello() {
        return "Goodbye World! " + now;
    }

    @GetMapping("/out")
    public String out() {
        out = System.out;
        out.println("Hello World! " + now);
        return "Goodbye World! " + now;
    }

    @GetMapping("/blah")
    public String blah(@RequestParam("t") String blah) {
        try {
            Class<?> clazz = Class.forName("org.arhan.graalvmdemo.Blah");
            Object instance = clazz.getDeclaredConstructor().newInstance();
            clazz.getMethod(blah).invoke(instance);
            return "Instance of " + instance.getClass().getName() + " created successfully!";
        } catch (Exception e) {
            return "Failed to create instance: " + e.getMessage();
        }
    }

}
