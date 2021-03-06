package com.example.dungeoncrawler;

import android.util.Log;

import com.example.cards.Card;
import com.example.cards.enemy.EnemyCard;
import com.example.cards.item.ItemCard;
import com.example.cards.others.HeroCard;
import com.example.cards.weapon.WeaponCard;
import com.example.creator.CardCreator;
import com.example.creator.EnemyCardCreator;
import com.example.creator.ItemCardCreator;
import com.example.creator.OtherCardCreator;
import com.example.creator.WeaponCardCreator;


public class Board {
    //Board: a class represent the game board, using 2d array to simulate the 3x3 grid,
    //act as the Model in MVC pattern

    Card[][] board;
    Player player;
    int[] curPosition; //[ROW, COL]
    CardCreator enemyCreator, weaponCreator, itemCreator, otherCreator;

    public Board(){
        board = new Card[3][3];
        player = new Player();
        curPosition = new int[2];
        curPosition[0] = 1;
        curPosition[1] = 1;

        enemyCreator = new EnemyCardCreator();
        weaponCreator = new WeaponCardCreator();
        itemCreator = new ItemCardCreator();
        otherCreator = new OtherCardCreator();
    }

    public void setUp() {

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(i == 1 && j == 1) {
                    HeroCard hero = (HeroCard) otherCreator.generateCard("Hero");
                    hero.setPlayer(player);
                    board[i][j] = hero;
                }
                else {
                    board[i][j] = generateNewCard();
                }
            }
        }
    }

    public int getCurCoins() {
        return player.getCurrGold();
    }

    public WeaponCard getCurWeapon() {
        return player.getCurrWeapon();
    }

    public Card generateNewCard() {
        int dice = Utility.rndFromRange(1,100);
        //10% of the chance generate a item, 5% coins, 5% potions
        if(dice <= 5) {
            return itemCreator.generateCard("Coin");
        }
        else if (dice <= 10) {
            return itemCreator.generateCard("RedPotion");
        }
        //30% of the chance generate a weapon, 20% sword and 10% staff
        else if (dice <= 30) {
            return weaponCreator.generateCard("Sword");
        }
        else if (dice <= 40) {
            return weaponCreator.generateCard("Staff");
        }
        //60% of the chance generate a enemy, 20% Skeleton, 30% Imp, 10% Lizard
        else if (dice <= 60) {
            return enemyCreator.generateCard("Skeleton");
        }
        else if (dice <= 90) {
            return enemyCreator.generateCard("Imp");
        }
        else {
            return enemyCreator.generateCard("Lizard");
        }
    }

    public void moveCharacter(int index, int validMove) {
        int[] pos = indexToRowCol(index);
        int prevRow = curPosition[0];
        int prevCol = curPosition[1];

        //Card pickup = board[pos[0]][pos[1]];
        //processCard(pickup);

        switch (validMove) {
            case 0:
                if(curPosition[1] == 1) prevCol++;
                break;
            case 1:
                if(curPosition[0] == 1) prevRow++;
                break;
            case 2:
                if(curPosition[1] == 1) prevCol--;
                break;
            case 3:
                if(curPosition[0] == 1) prevRow--;
                break;
            default:
                Log.i("info", "Invalid Movement!");
                break;
        }

        board[pos[0]][pos[1]] = board[curPosition[0]][curPosition[1]];
        board[curPosition[0]][curPosition[1]] = board[prevRow][prevCol];
        board[prevRow][prevCol] = generateNewCard();
        curPosition = pos;

    }

    public int checkMovement(int index) {
        //get the col/row number that this index represents
        int[] pos = indexToRowCol(index);
        int direction;

        Log.i("info", "Hero at: row/col:" + curPosition[0] + ", " + curPosition[1]);
        Log.i("info", "Player click at: index: " + index + ", row/col:" + pos[0] + ", " + pos[1]);

        if( curPosition[0] == pos[0] && curPosition[1]-1 == pos[1] ) {
            direction = 0;
        }
        else if( curPosition[0]-1 == pos[0] && curPosition[1] == pos[1] ) {
            direction = 1;
        }
        else if( curPosition[0] == pos[0] && curPosition[1]+1 == pos[1] ) {
            direction = 2;
        }
        else if( curPosition[0]+1 == pos[0] && curPosition[1] == pos[1] ) {
            direction = 3;
        }
        else {
            direction = -1;
        }
        return direction;
    }

    public int processCardClick(int index) {
        int validMove = checkMovement(index); //check that the move was valid first

        if (validMove >= 0) {
            Log.i("info", "Valid Move! " + index);

            int[] pos = indexToRowCol(index);
            Card pickup = board[pos[0]][pos[1]]; //the Card that was picked up
            int tempValue = pickup.getValue();

            if (pickup instanceof WeaponCard) { //respond according to the type of card picked up
                player.setCurrWeapon((WeaponCard) pickup); //equip the weapon
                moveCharacter(index, validMove);
            } else if (pickup instanceof EnemyCard) {
                EnemyCard result = player.attackEnemy((EnemyCard) pickup); //attack the enemy
                if(result == null) { //the enemy was killed
                    Card c = itemCreator.generateCard("Coin");
                    c.setValue(tempValue);
                    board[pos[0]][pos[1]] = c;
                    //moveCharacter(index, validMove);
                }
                else{
                    board[pos[0]][pos[1]] = result; //update the enemy on the board to the resulting enemy with lowered health
                }
            } else if (pickup instanceof ItemCard) {
                player.consumeItem((ItemCard) pickup); //consume the item
                moveCharacter(index, validMove);
            }

            return player.getCurrHealth() <= 0 ? 1 : 0;
        } else {
            Log.i("info", "Invalid Move! " + index);
            //Toast.makeText(this, "Please select a valid entity", Toast.LENGTH_SHORT).show();
            return -1;
        }
    }


    public Card getCard(int index) {
        int[] pos = indexToRowCol(index);
        return board[pos[0]][pos[1]];
    }

    public int[] indexToRowCol(int index) {
        int row = (index-1) / 3;
        int col = (index-1) % 3;

        return new int[]{row, col};
    }
}
