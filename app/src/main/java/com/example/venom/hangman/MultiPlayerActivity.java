package com.example.venom.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MultiPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);
    }


    public void playButton( View v)
    {
        EditText editTextWord1 = (EditText)findViewById(R.id.editTextWord);
        String wordToSent = editTextWord1.getText().toString();
        Intent myIntent = new Intent(this,GameTwoActivity.class);
        myIntent.putExtra("WORD" ,wordToSent);
        startActivity(myIntent);
    }
}
