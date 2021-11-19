package com.example.cards.enemy;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class Enemy_Imp extends EnemyCard{

    public Enemy_Imp() {
        name = "Imp";
        resImage = R.drawable.enemy_imp;
        description = "Common enemy. Deals damage that equals its health points.";
        healthPoints = Utility.rndFromRange(2, 4);
    }
}
