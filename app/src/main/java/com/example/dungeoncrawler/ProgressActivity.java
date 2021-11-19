package com.example.dungeoncrawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProgressActivity extends AppCompatActivity {

    Global global;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        global = Global.getInstance();

        backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(view -> openActivityMain());
    }

    public void openActivityMain() {
        finish();
    }
}