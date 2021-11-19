package com.example.dungeoncrawler;

import com.example.cards.weapon.WeaponCard;
import com.example.cards.weapon.Weapon_Sword;

public class Player {

    int maxHealth;
    int currHealth;

    WeaponCard currWeapon;

    public Player() {
        maxHealth = 10;
        currHealth = 10;
        currWeapon = new Weapon_Sword();
        currWeapon.setValue(3);
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public WeaponCard getCurrWeapon() {
        return currWeapon;
    }

    public void setCurrWeapon(WeaponCard currWeapon) {
        this.currWeapon = currWeapon;
    }
}
