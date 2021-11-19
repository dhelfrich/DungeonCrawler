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
    int[] curPosition; //[ROW, COL]

    public Board(){
        board = new Card[3][3];
        player = new Player();
        curPosition = new int[2];
        curPosition[0] = 1;
        curPosition[1] = 1;
    }

    public void setUp() {

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == curPosition[0] && j == curPosition[1]) {
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

    //check if moving to the card at index is valid (if it is a neighbour or not..)
    public boolean checkCard(int index) {
        //get the col/row number that this index represents
        int[] pos = indexToRowCol(index);
        int col = (int) Math.floor((index-1) / 3);
        int row = (index-1) % 3;

        System.out.println("Hero at: row/col:" + curPosition[0] + ", " + curPosition[1]);
        System.out.println("Player click at: index: " + index + ", row/col:" + pos[0] + ", " + pos[1]);

        if(
            ((curPosition[0] == pos[0]+1) && (curPosition[1] == pos[1])) ||
            ((curPosition[0] == pos[0]-1) && (curPosition[1] == pos[1])) ||
            ((curPosition[0] == pos[0]) && (curPosition[1] == pos[1]+1)) ||
            ((curPosition[0] == pos[0]) && (curPosition[1] == pos[1]-1))
        ) {
            System.out.println("Valid Move! " + index);
            return true;
        }
        else {
            System.out.println("Invalid Move! " + index);
            return false;
        }

    }

    public Card getCard(int index) {
        int[] pos = indexToRowCol(index);

        System.out.println("getcard(index = " + index + ")  row/col: " + pos[0] + ", " + pos[1]);
        return board[pos[0]][pos[1]];
    }

    public void SetCurPosition(int index) {
        curPosition = indexToRowCol(index);
    }

    public int[] indexToRowCol(int index) {
        int row = (int) Math.floor((index-1) / 3);
        int col = (index-1) % 3;
        int[] result = {row, col};

        return result;
    }
}
