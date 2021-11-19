package com.example.cards.weapon;

import com.example.cards.Card;

public class WeaponCard extends Card {

    int durability;
    boolean range;
    float valueFactor; //multiplied by health to calculate how much gold the weapon is worth when sold

    @Override
    public Integer getValue() {
        return durability;
    }

    @Override
    public void setValue(int value) {
        durability = value;
    }

    public boolean isRangeWeapon() { return range; }

    public float getValueFactor() {
        return valueFactor;
    }
}
