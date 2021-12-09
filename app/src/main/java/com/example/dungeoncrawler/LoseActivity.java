package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoseActivity extends AppCompatActivity {
    //LoseActivity: a screen shows up after player lose the game

    Global global;
    private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        global = Global.getInstance();

        menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(view -> openActivityMain());

        TextView textScoreBest = findViewById(getResources().getIdentifier("textScoreBest", "id", getPackageName()));
        TextView textScoreRecent = findViewById(getResources().getIdentifier("textScoreRecent", "id", getPackageName()));

        textScoreBest.setText(String.valueOf(global.getBestScore()));
        textScoreRecent.setText(String.valueOf(global.getRecentScore()));


    }

    public void openActivityMain() {
        finish();
    }
}