package com.example.cards.item;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class Item_Coin extends ItemCard{

    public Item_Coin() {
        name = "Gold Coin";
        resImage = R.drawable.item_coin;
        description = "You should collect some coins!";
        itemValue = Utility.rndFromRange(1, 6);
    }

    public Item_Coin(int itemValue) {
        name = "Gold Coin";
        resImage = R.drawable.item_coin;
        description = "You should collect some coins!";
        this.itemValue = itemValue;
    }
}
