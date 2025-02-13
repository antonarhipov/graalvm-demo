package org.demo.graalvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/rotate")
public class PangramRotator {

    static LocalDateTime timestamp = LocalDateTime.now();

    int index = 0;

    final PangramGenerator pangramGenerator;

    public PangramRotator(PangramGenerator pangramGenerator) {
        this.pangramGenerator = pangramGenerator;
    }

    @GetMapping
    public String hello() {
        String[] pangrams = pangramGenerator.getAllPangrams();
        //reset index if index >= pangrams.length
        String pangram = "(not found)";
        if (pangrams != null && pangrams.length > 0) {
            pangram = pangrams[index];
            index++;
            if(index == pangrams.length) {
                index = 0;
            }
        }
        return formattedTimestamp() + " >> '" + pangram + "'";
    }

    private static String formattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return timestamp.format(formatter);
    }

}
