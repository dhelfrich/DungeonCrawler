package com.example.dungeoncrawler;

public class Player {

    int maxHealth;
    int currHealth;

    int currGold;

    WeaponCard currWeapon;

    //create and assign a new weapon to the player
    public void getNewWeapon() {
        currWeapon = new WeaponCard();
    }

}
