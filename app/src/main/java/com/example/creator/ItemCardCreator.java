package com.example.creator;

import com.example.cards.Card;
import com.example.cards.item.Item_Coin;
import com.example.cards.item.Item_RedPotion;
import com.example.dungeoncrawler.Utility;

public class ItemCardCreator extends CardCreator{

    @Override
    public Card generateCard(String card) {
        switch (card) {
            case "Coin":
                return new Item_Coin();
            case "RedPotion":
                return new Item_RedPotion();
            default:
                int random = Utility.rndFromRange(0, 1);
                if (random == 0) return new Item_Coin();
                else return new Item_RedPotion();
        }
    }
}
