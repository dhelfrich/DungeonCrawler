package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProgressActivity extends AppCompatActivity {
    //ProgressActivity: a screen shows the game progress of player

    Global global;
    private Button backButton;
    TextView bestScore, maxRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        global = Global.getInstance();

        bestScore = findViewById(R.id.textBestScore);
        bestScore.setText(String.valueOf(global.getBestScore()));
        maxRecord = findViewById(R.id.textMaxRecord);
        maxRecord.setText(String.valueOf(global.getMaxSurvivedTurn()));
        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> openActivityMain());
    }

    public void openActivityMain() {
        finish();
    }
}