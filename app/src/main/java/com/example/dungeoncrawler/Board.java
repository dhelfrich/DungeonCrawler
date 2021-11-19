package com.example.dungeoncrawler;

import com.example.cards.Card;
import com.example.cards.enemy.Enemy_Imp;
import com.example.cards.enemy.Enemy_Lizard;
import com.example.cards.enemy.Enemy_Skeleton;
import com.example.cards.item.Item_Coin;
import com.example.cards.item.Item_RedPotion;
import com.example.cards.others.HeroCard;
import com.example.cards.weapon.Weapon_Staff;
import com.example.cards.weapon.Weapon_Sword;

public class Board {

    Card[][] board;
    Player player;
    int[] curPosition;

    public Board(){
        board = new Card[3][3];
        curPosition = new int[2];
    }

    public void setUp() {
        player = new Player();
        curPosition[0] = 1;
        curPosition[1] = 1;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) {
                    board[i][j] = new HeroCard(player);
                }
                else {
                    int dice = Utility.rndFromRange(1,100);
                    //20% of the chance generate a item, 5% coins, 15% potions
                    if(dice <= 5) {
                        board[i][j] = new Item_Coin();
                    }
                    else if (dice <= 20) {
                        board[i][j] = new Item_RedPotion();
                    }
                    //30% of the chance generate a weapon, 15% sword and staff
                    else if (dice <= 35) {
                        board[i][j] = new Weapon_Sword();
                    }
                    else if (dice <= 50) {
                        board[i][j] = new Weapon_Staff();
                    }
                    //50% of the chance generate a enemy, 20% Skeleton, 20% Imp, 10% Lizard
                    else if (dice <= 70) {
                        board[i][j] = new Enemy_Skeleton();
                    }
                    else if (dice <= 90) {
                        board[i][j] = new Enemy_Imp();
                    }
                    else {
                        board[i][j] = new Enemy_Lizard();
                    }
                }
            }
        }
    }

    public Card getCard(int index) {
        return board[index / 3][index % 3];
    }
}
