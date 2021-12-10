package com.example.creator;

import com.example.cards.Card;
import com.example.cards.enemy.Enemy_Imp;
import com.example.cards.enemy.Enemy_Lizard;
import com.example.cards.enemy.Enemy_Skeleton;
import com.example.dungeoncrawler.Utility;

public class EnemyCardCreator extends CardCreator{

    @Override
    public Card generateCard(String card) {
        switch (card) {
            case "Skeleton":
                return new Enemy_Skeleton();
            case "Imp":
                return new Enemy_Imp();
            case "Lizard":
                return new Enemy_Lizard();
            default:
                int random = Utility.rndFromRange(0, 2);

                if (random == 0) return new Enemy_Skeleton();
                else if (random == 1) return new Enemy_Imp();
                else return new Enemy_Lizard();
        }
    }
}
