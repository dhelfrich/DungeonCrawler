package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

//should be just activity not appcompat?
public class MainActivity extends AppCompatActivity {

    private Global global;

    private Button playButton;
    private Button progressButton;
    private Button settingButton;
    private Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        global = Global.getInstance();

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

        settingButton = (Button) findViewById(R.id.settingButton);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivitySetting();
            }
        });

        exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeActivityMain();
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

    public void openActivitySetting() {

    }

    public void closeActivityMain() {
        finish();
        System.exit(0);
    }
}