package com.example.venom.hangman;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);


        SharedPreferences preferences = getSharedPreferences("MYPREFERENCES", MODE_PRIVATE);
        String scores = preferences.getString("SCORES","NO SCORES");

        TextView textView = (TextView) findViewById(R.id.textPoints);
        textView.setText(scores);
    }
}
