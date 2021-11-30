package com.example.dungeoncrawler;

import com.example.cards.enemy.EnemyCard;
import com.example.cards.item.ItemCard;
import com.example.cards.item.Item_Coin;
import com.example.cards.item.Item_RedPotion;
import com.example.cards.weapon.WeaponCard;
import com.example.cards.weapon.Weapon_Sword;

public class Player {

    int maxHealth;
    int currHealth;

    WeaponCard currWeapon;


    int currGold;

    public Player() {
        maxHealth = 10;
        currHealth = 10;
        currWeapon = new Weapon_Sword();
        currWeapon.setValue(3);
    }

    public int getCurrHealth() {
        return currHealth;
    }

    public void setCurrHealth(int currHealth) {
        this.currHealth = currHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public WeaponCard getCurrWeapon() {
        return currWeapon;
    }

    public void setCurrWeapon(WeaponCard currWeapon) {
        this.currWeapon = currWeapon;
    }

    //player will attack the given EnemyCard, return resulting EnemyCard (null if killed)
    public EnemyCard attackEnemy(EnemyCard target) {
        if(currWeapon != null) { //if player has a weapon, attack with the weapon
            EnemyCard result = useWeapon(target);
            return result;
        }
        else { //player has no weapon, attack with health
            if(currHealth >= target.getValue()) { //the enemy will die from attack
                currHealth -= target.getValue();
                return null;
            }
            else { //enemy survives attack, player is killed
                target.setValue(target.getValue() - currHealth);
                currHealth = 0;
                return target;
            }
        }
    }

    //attack the given EnemyCard with equipped weapon, return resulting EnemyCard (null if killed)
    public EnemyCard useWeapon(EnemyCard target) {
        EnemyCard result = currWeapon.attackEnemy(target);
        if(currWeapon.getValue() <= 0) loseWeapon();
        return result;
    }

    //note: all items just heal for now
    public void consumeItem(ItemCard item) {
        if(item instanceof Item_Coin){
            currGold += item.getValue();
        }
        else if(item instanceof Item_RedPotion){
            currHealth += item.getValue();
        }
        else {

        }
    }

    public void loseWeapon() {
        currWeapon = null;
    }
}
