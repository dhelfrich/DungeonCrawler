package com.example.creator;

import com.example.cards.Card;
import com.example.cards.weapon.Weapon_Staff;
import com.example.cards.weapon.Weapon_Sword;
import com.example.dungeoncrawler.Utility;

public class WeaponCardCreator extends CardCreator{

    @Override
    public Card generateCard(String card) {
        switch (card) {
            case "Sword":
                return new Weapon_Sword();
            case "Staff":
                return new Weapon_Staff();
            default:
                int random = Utility.rndFromRange(0, 1);
                if (random == 0) return new Weapon_Sword();
                else return new Weapon_Staff();
        }
    }
}
