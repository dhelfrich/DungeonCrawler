package com.example.cards.others;

import com.example.cards.Card;
import com.example.dungeoncrawler.R;
import com.example.dungeoncrawler.Utility;

public class EmptyCard extends Card {

    public EmptyCard() {
        name = "Empty";
        resImage = android.R.drawable.alert_dark_frame;
        description = "This card is empty.";
    }

    @Override
    public String displayValue() {
        return "";
    }

    @Override
    public Integer getValue() {
        return null;
    }

    @Override
    public void setValue(int value) {}
}
