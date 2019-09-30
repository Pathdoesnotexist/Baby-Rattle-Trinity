package com.example.babyrattletrinity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class GameA extends AppCompatActivity {
    private MediaPlayer aClickSound;                                                                   //СОЗДАЕМ ПЕРЕМЕННЫЕ
    private MediaPlayer aModeMusic;
    private Intent moveToMenuIntent;
    private ImageView pinkFlower;
    private ImageView yellowFlower;
    private ImageView blueFlower;
    private ImageView redFlower;
    private ImageView orangeFlower;
    private int hiddenFlowersCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_a);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //vertical orientation

        View overlay = findViewById(R.id.GameALayout);                                              //set fullscreen mode
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        aClickSound = MediaPlayer.create(this, R.raw.a_click);                              //set sounds
        aModeMusic = MediaPlayer.create(getApplicationContext(), R.raw.a_music);
        aModeMusic.start();
        aModeMusic.setLooping(true);

        moveToMenuIntent = new Intent(GameA.this, MainMenu.class);                    //back to menu

        pinkFlower = findViewById(R.id.pinkFlower);                                                 //flowers
        yellowFlower = findViewById(R.id.yellowFlower);
        blueFlower = findViewById(R.id.blueFlower);
        redFlower = findViewById(R.id.redFlower);
        orangeFlower = findViewById(R.id.orangeFlower);

        RotateAnimation rotateRight = new RotateAnimation(                                          //rotation right function
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.55f,
                Animation.RELATIVE_TO_SELF, 0.55f
        );
        rotateRight.setDuration(10000);
        rotateRight.setRepeatCount(Animation.INFINITE);

        RotateAnimation rotateLeft = new RotateAnimation(                                           //rotation left function
                0, -360,
                Animation.RELATIVE_TO_SELF, 0.45f,
                Animation.RELATIVE_TO_SELF, 0.45f
        );
        rotateLeft.setDuration(10000);
        rotateLeft.setRepeatCount(Animation.INFINITE);

        pinkFlower.startAnimation(rotateRight);                                                     //start rotation
        yellowFlower.startAnimation(rotateLeft);
        blueFlower.startAnimation(rotateRight);
        redFlower.startAnimation(rotateLeft);
        orangeFlower.startAnimation(rotateRight);
    }


    public void moveToMenu(View view) {                                                             //ВЫХОД В МЕНЮ
        startActivity(moveToMenuIntent);
        if (aModeMusic.isPlaying()) {
            aModeMusic.stop();
        }
    }

    public void flowerAnimation (ImageView colorOfFlower) {                                         //ФУНКЦИЯ АНИМАЦИИ ИСЧЕЗНОВЕНИЯ ЦВЕТКА

        if (hiddenFlowersCount == 5) {
            pinkFlower.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(2000);
            yellowFlower.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(2000);
            blueFlower.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(2000);
            redFlower.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(2000);
            orangeFlower.animate().scaleX(1.0f).scaleY(1.0f).alpha(1).setDuration(2000);
            hiddenFlowersCount = 0;
        } else {
            colorOfFlower.animate().rotationBy(3600).scaleX(0.0f).scaleY(0.0f).setDuration(2000).alpha(0);
            hiddenFlowersCount++;
            aClickSound.start();
        }

    }

    public void pinkGone(View view) {                                                               //ОБРАБОТКА КЛИКОВ ПО ЦВЕТАМ
        flowerAnimation(pinkFlower);
    }

    public void yellowGone(View view) {
        flowerAnimation(yellowFlower);
    }

    public void blueGone(View view) {
        flowerAnimation(blueFlower);
    }

    public void redGone(View view) {
        flowerAnimation(redFlower);
    }

    public void orangeGone(View view) {
        flowerAnimation(orangeFlower);
    }

    public void onDestroy() {
        super.onDestroy();
        if (aModeMusic.isPlaying()) {
            aModeMusic.stop();
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        aModeMusic.start();
//    }
}
