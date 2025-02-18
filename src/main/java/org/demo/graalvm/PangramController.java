package org.demo.graalvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class PangramController {

    static LocalDateTime timestamp = LocalDateTime.now();

    @Autowired
    PangramsGenerator pangramsGenerator;

    @GetMapping("/")
    public String hello() {
        return formattedTimestamp() + " >> '" + pangramsGenerator.getRandomPangram() + "'";
    }

    private static String formattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }
}
