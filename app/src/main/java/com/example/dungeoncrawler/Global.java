package com.example.dungeoncrawler;

public class Global {
    private static Global uniqueInstance = null;

    int highestScore = 0;

    private Global() {

    }

    public static synchronized Global getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Global();
        }
        return uniqueInstance;
    }
}
