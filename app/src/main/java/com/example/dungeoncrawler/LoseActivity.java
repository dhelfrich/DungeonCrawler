package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoseActivity extends AppCompatActivity {

    Global global;
    private Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);
        global = Global.getInstance();

        menuButton = (Button) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(view -> openActivityMain());
    }

    public void openActivityMain() {
        finish();
    }
}