package com.example.cards.enemy;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class Enemy_Lizard extends EnemyCard{

    public Enemy_Lizard() {
        name = "Lizard";
        resImage = R.drawable.enemy_lizard;
        description = "Common enemy. Deals damage that equals its health points.";
        healthPoints = Utility.rndFromRange(4, 7);
    }
}
