package com.example.dungeoncrawler;

public class Global {
    //Global: class tracks the player's score, and it is shared among other classes
    //Implemented Design Pattern: Singleton

    private static Global uniqueInstance = null;

    private int bestScore;
    private int recentScore;
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

    public int getRecentScore() {
        return recentScore;
    }
    public void setRecentScore(int recentScore) {
        this.recentScore = recentScore;
    }

    public int getMaxSurvivedTurn() {
        return maxSurvivedTurn;
    }

    public void setMaxSurvivedTurn(int maxSurvivedTurn) {
        this.maxSurvivedTurn = maxSurvivedTurn;
    }
}
