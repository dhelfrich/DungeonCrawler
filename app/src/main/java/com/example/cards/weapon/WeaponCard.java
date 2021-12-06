package com.example.cards.weapon;

import com.example.cards.Card;
import com.example.cards.enemy.EnemyCard;

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

    //weapon attacks enemy, returns resulting enemy (null if enemy killed)
    public EnemyCard attackEnemy(EnemyCard target) {

        if(durability >= target.getValue()) { //the enemy will die from attack
            durability -= target.getValue();
            return null;
        }
        else { //enemy survives attack, weapon is destroyed
            target.setValue(target.getValue() - durability);
            durability = 0;
            return target;
        }
    }
}
