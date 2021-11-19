package com.example.dungeoncrawler;

import java.util.Random;

public interface Utility {

    static int rndFromRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

}
