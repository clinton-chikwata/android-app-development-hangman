package com.example.venom.hangman;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Runnable runnable4Secs = new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        };

        Handler myHandler = new Handler();
        myHandler.postDelayed(runnable4Secs ,4000);

    }

    public void nextActivity()
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
