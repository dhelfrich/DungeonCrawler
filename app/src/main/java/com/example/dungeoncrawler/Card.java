package com.example.dungeoncrawler;

public abstract class Card {
    String name;
    String imagePath;

    //method called when the player picks up this card during game
    public abstract void processInteract();
}

