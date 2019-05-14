package com.example.venom.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    String mWord ;
    int failedCounter = 0;
    int correctGuess = 0;
    int points = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRandomWord();
    }
//Retrieving the letter introduced from the edit text

    public void introduceLetter(View v)
    {
        EditText myEditText = (EditText)findViewById(R.id.editTextLetter);

        String letter = myEditText.getText().toString();

        myEditText.setText("");
        Log.d("my log","the letter is"+ letter );

        if(letter.length() > 0)
        {
            checkLetter(letter.toUpperCase());
        }
        else
        {
            Toast.makeText(this,"Please insert a letter ",Toast.LENGTH_SHORT).show();
        }
    }

//Checking if the letter introduced matches any letter
 public void checkLetter(String introducedLetter){

     char charIntroduced = introducedLetter.charAt(0);

     Boolean letterGuessed = false;

     for(int i = 0; i < mWord.length(); i++)
     {
         char charFromTheWord = mWord.charAt(i);
         Log.d("MYLOG" ,"The letter we are checking is "+ charFromTheWord);
         if(charFromTheWord == charIntroduced)
         {
             Log.d("MYLOG" ,"There was one match");
             letterGuessed = true;
             showLettersAtIndex(i,charIntroduced);

             correctGuess++;

         }
     }

     if(letterGuessed == false)
     {
         letterFailed(Character.toString(charIntroduced));
     }

     if(correctGuess == mWord.length())
     {
         points = points + 10;
         clearScreen();
         setRandomWord();
     }
 }

 public void setRandomWord()
 {
     String words = "ABLE ACER ACHE ACID ACME ACRE ACTS AFRO AGED AGES AIDS AIMS ANTI ANTS ANUS ATOM AUNT AWAY AXES BABA BABE BABY BACK BAGS BAIL BAIT BAKE BALD BALL BALM BAND BANG BANK BARE BARK BARN BARS BASE BASS BATH BATS BAWL BAYS BEAK BEAM BEAN BEAR BEAT BEDS BEEN BEEP BEER BEES BELL BELT BEND BENT BEST BETS BIKE BILE BILL BIND BINS BIOS BIRD BITE BITS BLED BLEW BLOB BLOC BLOG BLOT BLOW BLUE BLUR BOAR BODY BOLD BOLE BOLL BOLT BOMB BOND BONE BONK BOOB BOOK BOOM BOOT BORE BORN BOSS BOTH BOYS BRAT BREW BUCK BUDS BUGS BULB BULK BULL BUMP BUMS BUNK BUNS BUNT BURD BURN BURY BUSH BUSK BUST BUSY BUTS BUTT BUYS BUZZ";
     String[] arrayWords = words.split(" ");

     Log.d("MYLOG" , "array length" + arrayWords.length);

     int randomNumber = (int) (Math.random() * arrayWords.length);
     String randomWord = arrayWords[randomNumber];
     mWord =randomWord;

 }
//IF Letter being guessed is finished do clear the screen
 public void clearScreen(){
     TextView textViewFailed = (TextView) findViewById(R.id.textView7);
     textViewFailed.setText("");

     correctGuess=0;
     failedCounter=0;

     LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.LayoutLetters);

     for(int i = 0; i < layoutLetter.getChildCount(); i++)
     {
         TextView currentTextView = (TextView) layoutLetter.getChildAt(i);
         currentTextView.setText("_");
     }
     ImageView imageView = (ImageView) findViewById(R.id.imageView2);
     imageView.setImageResource(R.drawable.hangman);
 }

 //showing what happens when user fail a letter
 public void letterFailed(String letterFailed)
 {
     TextView textViewFailed = (TextView) findViewById(R.id.textView7);
     String previousFailed = textViewFailed.getText().toString();
     textViewFailed.setText(previousFailed+" "+letterFailed);
     failedCounter++;
     ImageView imageView = (ImageView) findViewById(R.id.imageView2);

     if(failedCounter == 1)
     {
         imageView.setImageResource(R.drawable.hangman1);
     }
     else if(failedCounter ==2)
     {
         imageView.setImageResource(R.drawable.hangman2);
     }
     else if(failedCounter == 3)
     {
         imageView.setImageResource(R.drawable.hangman3);
     }
     else if(failedCounter == 4)
     {
         imageView.setImageResource(R.drawable.hangman4);
     }
     else if(failedCounter == 5)
     {
         imageView.setImageResource(R.drawable.hangman5);
     }
     else if(failedCounter == 6)
     {
         Intent gameOverIntent =  new Intent(this,GameOverActivity.class);

         gameOverIntent.putExtra("POINTS", points);
         startActivity(gameOverIntent);
         finish();
     }
 }

//Displaying a letter guessed by the user
 public void showLettersAtIndex(int position , char letterGuessed)
 {
    LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.LayoutLetters);
     TextView textView = (TextView) layoutLetter.getChildAt(position);
     textView.setText(Character.toString(letterGuessed));
 }


}
