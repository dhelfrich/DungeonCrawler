package com.example.cards.weapon;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class Weapon_Sword extends WeaponCard{

    public Weapon_Sword() {
        name = "Sword";
        resImage = R.drawable.weapon_sword;
        description = "Deals damage to enemies.";
        durability = Utility.rndFromRange(3, 6);
        range = false;
        valueFactor = 1;
    }
}
