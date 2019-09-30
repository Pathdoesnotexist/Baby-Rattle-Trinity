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

public class GameB extends AppCompatActivity {

    private MediaPlayer bModeMusic;
    private MediaPlayer cowV;
    private MediaPlayer crocV;
    private MediaPlayer hippoV;
    private MediaPlayer elephV;
    private MediaPlayer horseV;
    private MediaPlayer parrotV;
    private MediaPlayer pigV;
    private MediaPlayer snakeV;
    private MediaPlayer zebraV;
    private MediaPlayer giraffeV;
    private MediaPlayer dogV;
    private MediaPlayer toadV;

    private Intent moveToMenuIntent;

    public ImageView cow;
    public ImageView croc;
    public ImageView hippo;
    public ImageView eleph;
    public ImageView horse;
    public ImageView parrot;
    public ImageView pig;
    public ImageView snake;
    public ImageView zebra;
    public ImageView giraffe;
    public ImageView dog;
    public ImageView toad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_b);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //vertical orientation

        View overlay = findViewById(R.id.GameBLayout);                                              //set fullscreen mode
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        moveToMenuIntent = new Intent(GameB.this, MainMenu.class);

        ImageView[] animalsNames = {cow, croc, hippo, eleph, horse, parrot, pig, snake, zebra, giraffe, dog, toad};
        int[] animalsID ={R.id.cow,R.id.croc,R.id.hippo,R.id.elephant,R.id.horse,R.id.parrot,R.id.pig,R.id.snake,R.id.zebra,R.id.giraffe,R.id.dog,R.id.toad};

        bModeMusic = MediaPlayer.create(getApplicationContext(), R.raw.b_music);                    //set sound sources
        bModeMusic.start();
        bModeMusic.setLooping(true);
        cowV = MediaPlayer.create(this, R.raw.b_cow_sound);
        crocV = MediaPlayer.create(this, R.raw.b_croco_sound);
        hippoV = MediaPlayer.create(this, R.raw.b_hippo_sound);
        elephV = MediaPlayer.create(this, R.raw.b_eleph_sound);
        horseV = MediaPlayer.create(this, R.raw.b_horse_sound);
        parrotV = MediaPlayer.create(this, R.raw.b_parrot_sound);
        pigV = MediaPlayer.create(this, R.raw.b_pig_sound);
        snakeV = MediaPlayer.create(this, R.raw.b_snake_sound);
        zebraV = MediaPlayer.create(this, R.raw.b_zebra_sound);
        giraffeV = MediaPlayer.create(this, R.raw.b_giraffe_sound);
        dogV = MediaPlayer.create(this, R.raw.b_dog_sound);
        toadV = MediaPlayer.create(this, R.raw.b_frog_sound);

        RotateAnimation headNormal = new RotateAnimation(                                           //heads rotation
                -20, 20,
                Animation.RELATIVE_TO_SELF, 0.50f,
                Animation.RELATIVE_TO_SELF, 0.50f
        );
        headNormal.setDuration(2000);
        headNormal.setRepeatMode(Animation.REVERSE);
        headNormal.setRepeatCount(Animation.INFINITE);

        for (int i = 0;i < animalsNames.length; i++) {                                              //rotation start
            animalsNames[i] = findViewById(animalsID[i]);
            animalsNames[i].startAnimation(headNormal);
        }
    }

    public void moveToMenu(View view) {                                                             //ВЫХОД В МЕНЮ
        startActivity(moveToMenuIntent);
        if (bModeMusic.isPlaying()) {
            bModeMusic.stop();
        }
    }
                                                                                                    //sound activation on click
    public void cowClick(View view) {
        cowV.start();
    }
    public void crocClick(View view) {
        crocV.start();
    }
    public void elephClick(View view) {
        elephV.start();
    }
    public void hippoClick(View view) {
        hippoV.start();
    }
    public void horseClick(View view) {
        horseV.start();
    }
    public void parrotClick(View view) {
        parrotV.start();
    }
    public void pigClick(View view) {
        pigV.start();
    }
    public void snakeClick(View view) {
        snakeV.start();
    }
    public void zebraClick(View view) {
        zebraV.start();
    }
    public void giraffeClick(View view) {
        giraffeV.start();
    }
    public void dogClick(View view) {
        dogV.start();
    }
    public void toadClick(View view) {
        toadV.start();
    }

    public void onDestroy() {
        super.onDestroy();
        if (bModeMusic.isPlaying()) {
            bModeMusic.stop();
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        bModeMusic.start();
//    }

}
