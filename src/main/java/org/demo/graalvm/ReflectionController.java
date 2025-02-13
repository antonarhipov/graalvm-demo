package org.demo.graalvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reflection")
public class ReflectionController {

    @GetMapping
    public String invoke(@RequestParam("method") String methodName) {
        try {
            Class<?> clazz = Class.forName("org.demo.graalvm.Pangrams");
            Object instance = clazz.getDeclaredConstructor().newInstance();
            Object result = clazz.getMethod(methodName).invoke(instance);
            return "The result of " + methodName + " is: " + result;
        } catch (Exception e) {
            return "Failed to create instance: " + e.getMessage();
        }
    }

}
