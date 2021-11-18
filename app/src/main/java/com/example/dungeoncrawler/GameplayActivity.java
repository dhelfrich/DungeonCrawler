package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GameplayActivity extends AppCompatActivity {

    Global global;
    Button loseButton;
    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
        global = Global.getInstance();

        loseButton = findViewById(R.id.loseButton);
        loseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityLose();
            }
        });

        for(int i = 1; i < 10; i++) {
            updateCard(i);
        }
    }

    @SuppressLint("SetTextI18n")
    public void updateCard(int index) {
        String hpTextId = "hpText" + index;
        int resId1 = getResources().getIdentifier(hpTextId, "id", getPackageName());
        TextView hpText = findViewById(resId1);
        hpText.setText("Sample HP");

        String imageViewId = "imageView" + index;
        int resId2 = getResources().getIdentifier(imageViewId, "id", getPackageName());
        ImageView imageView = findViewById(resId2);
        imageView.setImageResource(R.drawable.enemy_skeleton);

        String nameTextId = "nameText" + index;
        int resId3 = getResources().getIdentifier(nameTextId, "id", getPackageName());
        TextView nameText = findViewById(resId3);
        nameText.setText("Sample Name");

        String valueTextId = "valueText" + index;
        int resId4 = getResources().getIdentifier(valueTextId, "id", getPackageName());
        TextView valueText = findViewById(resId4);
        valueText.setText("Sample Value");
    }

    public void openActivityLose() {
        Intent intent = new Intent(this, LoseActivity.class);
        finish();
        startActivity(intent);
    }
}