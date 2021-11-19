package com.example.cards.weapon;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class Weapon_Staff extends WeaponCard{

    public Weapon_Staff() {
        name = "Staff";
        resImage = R.drawable.weapon_staff;
        description = "Deals damage to enemy and everything behind it.";
        durability = Utility.rndFromRange(5, 8);
        range = true;
        valueFactor = 1;
    }
}
