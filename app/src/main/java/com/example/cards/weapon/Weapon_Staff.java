package com.example.cards.weapon;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class Weapon_Staff extends WeaponCard{

    public Weapon_Staff() {
        name = "Staff";
        resImage = R.drawable.weapon_staff;
        description = "Deals damage to enemy but decrease incoming damage if enemy is killed.";
        durability = Utility.rndFromRange(4, 7);
        range = true;
        valueFactor = 1;
    }
}
