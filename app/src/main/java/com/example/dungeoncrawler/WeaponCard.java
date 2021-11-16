package com.example.dungeoncrawler;

public class WeaponCard extends Card {
    int health;

    float valueFactor; //multiplied by health to calculate how much gold the weapon is worth when sold

    @Override
    public void processInteract() {

    }

    public int sellWeapon() {
        return (int)(health * valueFactor);
    }
}
