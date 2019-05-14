package com.example.venom.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSinglePlayer(View v)
    {
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
    }

    public void startMultiPlayer(View v)
    {
        Intent intent = new Intent(this,MultiPlayerActivity.class);
        startActivity(intent);
    }
    public void startScore(View v)
    {
        Intent intent = new Intent(this,ScoreActivity.class);
        startActivity(intent);
    }
}
