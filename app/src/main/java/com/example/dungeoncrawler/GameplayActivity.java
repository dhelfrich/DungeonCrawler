package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameplayActivity extends AppCompatActivity {

    Button loseButton;

    Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);

        loseButton = findViewById(R.id.loseButton);
        loseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityLose();
            }
        });

        player = new Player();
    }

    public void openActivityLose() {
        Intent intent = new Intent(this, LoseActivity.class);
        startActivity(intent);
    }
}