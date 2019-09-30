package com.example.babyrattletrinity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainMenu extends AppCompatActivity {
    ImageButton aMode;
    ImageButton bMode;
    ImageButton cMode;
    MediaPlayer menuMusic;
    Intent toGameIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //vertical orientation

        View overlay = findViewById(R.id.MainMenuLayout);                                           //set fullscreen mode
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        aMode = findViewById(R.id.a_game_mode);
        bMode = findViewById(R.id.b_game_mode);
        cMode = findViewById(R.id.c_game_mode);

        toGameIntent = new Intent(MainMenu.this, GameA.class);

        menuMusic = MediaPlayer.create(getApplicationContext(), R.raw.menu_music);
        menuMusic.start();
        menuMusic.setLooping(true);
    }

    public void startTheGame(View view) {
        startActivity(toGameIntent);
        if (menuMusic.isPlaying()) {
            menuMusic.stop();
        }
    }

    public void startA(View view) {
        aMode.setImageResource(R.drawable.a_game_active);
        bMode.setImageResource(R.drawable.b_game_inactive);
        cMode.setImageResource(R.drawable.c_game_inactive);
        toGameIntent = new Intent(MainMenu.this, GameA.class);
    }

    public void startB(View view) {
        aMode.setImageResource(R.drawable.a_game_inactive);
        bMode.setImageResource(R.drawable.b_game_active);
        cMode.setImageResource(R.drawable.c_game_inactive);
        toGameIntent = new Intent(MainMenu.this, GameB.class);
    }

    public void startC(View view) {
        aMode.setImageResource(R.drawable.a_game_inactive);
        bMode.setImageResource(R.drawable.b_game_inactive);
        cMode.setImageResource(R.drawable.c_game_active);
        toGameIntent = new Intent(MainMenu.this, GameC.class);
    }

    public void onDestroy() {
        super.onDestroy();
        if (menuMusic.isPlaying()) {
            menuMusic.stop();
        }
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        menuMusic.start();
//    }
}
