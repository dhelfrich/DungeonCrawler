package com.example.dungeoncrawler;

public class Global {
    private static Global uniqueInstance = null;

    private int bestScore;
    private int maxSurvivedTurn;

    private Global() {
        bestScore = 0;
    }

    public static synchronized Global getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Global();
        }
        return uniqueInstance;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public int getMaxSurvivedTurn() {
        return maxSurvivedTurn;
    }

    public void setMaxSurvivedTurn(int maxSurvivedTurn) {
        this.maxSurvivedTurn = maxSurvivedTurn;
    }
}
