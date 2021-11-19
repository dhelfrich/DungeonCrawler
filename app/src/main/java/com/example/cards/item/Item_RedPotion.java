package com.example.cards.item;

import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class Item_RedPotion extends ItemCard{

    public Item_RedPotion() {
        name = "Red potion";
        resImage = R.drawable.item_flaskyellow;
        description = "Heals character.";
        itemValue = Utility.rndFromRange(3, 9);
    }
}
