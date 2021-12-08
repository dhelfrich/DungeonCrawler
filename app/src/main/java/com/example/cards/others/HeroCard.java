package com.example.cards.others;

import com.example.cards.Card;
import com.example.dungeoncrawler.Player;
import com.example.dungeoncrawler.R;

public class HeroCard extends Card {

    private Player player;

    public HeroCard () {
        name = "Hero";
        resImage = R.drawable.player_knight;
        description = "";
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
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
