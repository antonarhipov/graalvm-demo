package org.demo.graalvm;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PangramGenerator {

    private final String[] pangrams = new String[]{
            "Quick brown fox jumps over the lazy dog",
            "The five boxing wizards jump quickly",
            "Sphinx of black quartz, judge my vow",
            "Jack quickly vexed the awkward big frog",
            "The jay, pig, fox, zebra, and my wolves quack",
            "Pack my box with five dozen liquor jugs",
            "Mr Jock, TV quiz PhD, bags few lynx",
            "How quickly daft jumping zebras vex",
            "The quick onyx goblin jumps over the lazy dwarf",
            "Crazy Fredericka bought many very exquisite opal jewels"
    };

    public String getRandomPangram() {
        Random random = new Random();
        return pangrams[random.nextInt(pangrams.length)];
    }

    public String[] getAllPangrams() {
        return pangrams;
    }
}