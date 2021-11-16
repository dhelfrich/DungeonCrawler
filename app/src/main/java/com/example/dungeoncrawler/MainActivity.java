package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button playButton;
    private Button progressButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityGameplay();
            }
        });

        progressButton = (Button) findViewById(R.id.progressButton);
        progressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivityProgress();
            }
        });


    }

    public void openActivityGameplay() {
        Intent intent = new Intent(this, GameplayActivity.class);
        startActivity(intent);
    }

    public void openActivityProgress() {
        Intent intent = new Intent(this, ProgressActivity.class);
        startActivity(intent);
    }
}