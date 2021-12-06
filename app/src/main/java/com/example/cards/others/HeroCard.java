package com.example.cards.others;

import com.example.cards.Card;
import com.example.dungeoncrawler.Player;
import com.example.dungeoncrawler.R;

public class HeroCard extends Card {

    Player player;

    public HeroCard(Player player) {
        name = "No weapon";
        if(player.getCurrWeapon() != null) name = player.getCurrWeapon().getName() + " "+ player.getCurrWeapon().getValue().toString();
        resImage = R.drawable.player_knight;
        description = "";
        this.player = player;
    }

    @Override
    public String displayValue() {
        return super.displayValue() + "/" + player.getMaxHealth();
    }

    @Override
    public Integer getValue() {
        return player.getCurrHealth();
    }

    @Override
    public void setValue(int value) {
        player.setCurrHealth(value);
    }
}
