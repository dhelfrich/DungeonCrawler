package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cards.Card;
import com.example.cards.enemy.EnemyCard;
import com.example.cards.others.HeroCard;

public class GameplayActivity extends AppCompatActivity {

    Global global;
    Button loseButton;
    Board gameBoard = new Board();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        global = Global.getInstance();

        loseButton = findViewById(R.id.loseButton);
        loseButton.setOnClickListener(view -> openActivityLose());

        gameBoard.setUp();
        updateAllCard();
    }

    @SuppressLint("SetTextI18n")
    public void updateAllCard() {
        for(int i = 1; i < 10; i++) {
            String hpTextId = "hpText" + i;
            int resId1 = getResources().getIdentifier(hpTextId, "id", getPackageName());
            TextView hpText = findViewById(resId1);

            String imageViewId = "imageView" + i;
            int resId2 = getResources().getIdentifier(imageViewId, "id", getPackageName());
            ImageView imageView = findViewById(resId2);

            String nameTextId = "nameText" + i;
            int resId3 = getResources().getIdentifier(nameTextId, "id", getPackageName());
            TextView nameText = findViewById(resId3);

            String valueTextId = "valueText" + i;
            int resId4 = getResources().getIdentifier(valueTextId, "id", getPackageName());
            TextView valueText = findViewById(resId4);

            int layoutID = getResources().getIdentifier("card" + i, "id", getPackageName());
            LinearLayout layout = findViewById(layoutID);
            final int myIndex = i;
            layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickCardButton(myIndex);

            } });

            Card card = gameBoard.getCard(i);
            if (card.getClass().equals(HeroCard.class) || EnemyCard.class.isAssignableFrom(card.getClass())) {
                hpText.setText(card.displayValue());
                valueText.setText("");
            }
            else {
                hpText.setText("");
                valueText.setText(card.displayValue());
            }
            imageView.setImageResource(card.getResImage());
            nameText.setText(card.getName());
        }
    }

    public void clickCardButton(int index) {
        boolean validMove = gameBoard.checkCard(index);

        if(validMove) {
            gameBoard.SetCurPosition(index);
            gameBoard.setUp();
            updateAllCard();
        }
        else {

        }
    }

    public void openActivityLose() {
        Intent intent = new Intent(this, LoseActivity.class);
        finish();
        startActivity(intent);
    }
}

;