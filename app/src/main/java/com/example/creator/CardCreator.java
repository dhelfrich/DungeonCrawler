package com.example.creator;

import com.example.cards.Card;

public abstract class CardCreator {
    //CardCreator: abstract superclass, will create and return Card object
    //Implemented Design Pattern: Factory

    public abstract Card generateCard(String card);

}
