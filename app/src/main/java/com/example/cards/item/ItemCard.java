package com.example.cards.item;

import com.example.cards.Card;

public class ItemCard extends Card {

    int itemValue;

    @Override
    public Integer getValue() {
        return itemValue;
    }

    @Override
    public void setValue(int value) {
        itemValue = value;
    }
}
