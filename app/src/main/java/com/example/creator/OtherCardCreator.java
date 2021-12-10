package com.example.creator;

import com.example.cards.Card;
import com.example.cards.others.EmptyCard;
import com.example.cards.others.HeroCard;

public class OtherCardCreator extends CardCreator{

    @Override
    public Card generateCard(String card) {
        switch (card) {
            case "Hero":
                return new HeroCard();
            default:
                return new EmptyCard();
        }
    }
}
