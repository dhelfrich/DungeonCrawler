package com.example.cards.enemy;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class Enemy_Skeleton extends EnemyCard{

    public Enemy_Skeleton() {
        name = "Skeleton";
        resImage = R.drawable.enemy_skeleton;
        description = "Common enemy. Deals damage that equals its health points.";
        healthPoints = Utility.rndFromRange(1, 2);
    }
}
