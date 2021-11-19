package com.example.cards.enemy;

import com.example.cards.Card;

public class EnemyCard extends Card {

    int healthPoints;

    @Override
    public Integer getValue() {
        return healthPoints;
    }

    @Override
    public void setValue(int value) {
        healthPoints = value;
    }
}
