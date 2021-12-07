package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cards.Card;
import com.example.cards.enemy.EnemyCard;
import com.example.cards.others.HeroCard;
import com.example.cards.weapon.WeaponCard;

public class GameplayActivity extends AppCompatActivity {

    Global global;
    Button loseButton;
    Board gameBoard = new Board();
    ImageView coins, curWeapon;
    TextView numCoins, curWeaponValue;
    int survivedTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        global = Global.getInstance();
        survivedTurn = 0;

        coins = findViewById(R.id.coins);
        curWeapon = findViewById(R.id.curWeapon);
        numCoins = findViewById(R.id.numCoins);
        curWeaponValue = findViewById(R.id.curWeaponValue);

        loseButton = findViewById(R.id.loseButton);
        loseButton.setOnClickListener(view -> openActivityLose());

        for(int i = 1; i < 10; i++) {
            int layoutId = getResources().getIdentifier("card" + i, "id", getPackageName());
            LinearLayout layout = findViewById(layoutId);
            final int myIndex = i;
            layout.setOnClickListener(view -> clickCardButton(myIndex));
            layout.setLongClickable(true);
            layout.setOnLongClickListener(view -> {
                longClickCardButton(myIndex);
                return true;
            });
        }

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
        numCoins.setText(String.valueOf(gameBoard.getCurCoins()));
        WeaponCard weapon = gameBoard.getCurWeapon();
        if(weapon != null) {
            curWeapon.setImageResource(weapon.getResImage());
            curWeaponValue.setText(weapon.displayValue());
        }
        else {
            curWeapon.setImageResource(android.R.color.transparent);
            curWeaponValue.setText("");
        }
        survivedTurn++;
        global.setBestScore(Math.max(global.getBestScore(), gameBoard.getCurCoins()));
        global.setMaxSurvivedTurn(Math.max(global.getMaxSurvivedTurn(), survivedTurn));
    }

    public void clickCardButton(int index) {
        int signal = gameBoard.processCardClick(index);
        updateAllCard();
        // Signal are integers from -1 to 1, -1 means invalid move, 0 means game continue, 1 means game over
        if(signal == -1) {
            Toast.makeText(this, "Please select a valid card", Toast.LENGTH_SHORT).show();
        }
        else if(signal == 1) {
            openActivityLose();
        }
    }

    public void longClickCardButton(int index) {
        Card card = gameBoard.getCard(index);

        showPopupWindowLongClick(coins, card);
    }

    public void showPopupWindowLongClick(View view, Card card) {
        //Source: https://stackoverflow.com/questions/5944987/how-to-create-a-popup-window-popupwindow-in-android
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_long_click, null);
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);
        popupWindow.setElevation(20);

        //set attributes inside popup window
        ImageView imageLongClick = popupView.findViewById(R.id.imageLongClick);
        imageLongClick.setImageResource(card.getResImage());
        TextView nameLongClick = popupView.findViewById(R.id.nameLongClick);
        nameLongClick.setText(card.getName());
        TextView descriptionLongClick = popupView.findViewById(R.id.descriptionLongClick);
        descriptionLongClick.setText(card.getDescription());

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    public void openActivityLose() {
        Intent intent = new Intent(this, LoseActivity.class);
        finish();
        startActivity(intent);
    }
}