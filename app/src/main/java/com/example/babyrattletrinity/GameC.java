package com.example.babyrattletrinity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class GameC extends AppCompatActivity {

    private MediaPlayer cClickSound;
    private MediaPlayer cModeMusic;
    private Intent moveToMenuIntent;

    private int screenWidth;                                                                        //ШИРИНА ЭКРАНА
    private int screenHeight;

    private ImageView bluePlanet;                                                                   //ПЕРЕМЕННЫЕ ДЛЯ ПЛАНЕТ
    private ImageView greenPlanet;
    private ImageView orangePlanet;
    private ImageView pinkPlanet;
    private ImageView redPlanet;
    private ImageView violetPlanet;

    private float bluePlanetX;                                                                      //ПОЗИЦИЯ ПЛАНЕТ
    private float bluePlanetY;
    private float greenPlanetX;
    private float greenPlanetY;
    private float orangePlanetX;
    private float orangePlanetY;
    private float pinkPlanetX;
    private float pinkPlanetY;
    private float redPlanetX;
    private float redPlanetY;
    private float violetPlanetX;
    private float violetPlanetY;

    private Handler handler = new Handler();                                                        //ИНИЦИАЛИЗИРУЕМ КЛАСС
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_c);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);                          //vertical orientation

        View overlay = findViewById(R.id.GameCLayout);                                              //set fullscreen mode
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        cClickSound = MediaPlayer.create(this, R.raw.c_click);                              //УСТАНАВЛИВАЕМ ЗВУКИ
        cModeMusic = MediaPlayer.create(getApplicationContext(), R.raw.c_music);
        cModeMusic.start();
        cModeMusic.setLooping(true);

        moveToMenuIntent = new Intent(GameC.this, MainMenu.class);

        bluePlanet = findViewById(R.id.bluePlanet);                                                 //СВЯЗЫВАЕМ ПЕРЕМЕННЫЕ С IMAGEVIEW
        greenPlanet = findViewById(R.id.greenPlanet);
        orangePlanet = findViewById(R.id.orangePlanet);
        pinkPlanet = findViewById(R.id.pinkPlanet);
        redPlanet = findViewById(R.id.redPlanet);
        violetPlanet = findViewById(R.id.violetPlanet);

        WindowManager wm = getWindowManager();                                                      //ПОЛУЧАЕМ РАЗМЕР ЭКРАНА
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        bluePlanet.setX(screenHeight + 50.0f);                                                      //ДВИЖЕНИЕ ЗА ГРАНИЦЫ ЭКРАНА
        bluePlanet.setY(-50.0f);
        orangePlanet.setX(screenHeight + 200.0f);
        orangePlanet.setY(-200.0f);
        redPlanet.setX(screenHeight + 350.0f);
        redPlanet.setY(-350.0f);
        greenPlanet.setX(screenHeight + 50.0f);                                                      //ДВИЖЕНИЕ ЗА ГРАНИЦЫ ЭКРАНА
        greenPlanet.setY(-50.0f);
        pinkPlanet.setX(screenHeight + 200.0f);
        pinkPlanet.setY(-200.0f);
        violetPlanet.setX(screenHeight + 350.0f);
        violetPlanet.setY(-350.0f);

        timer.schedule(new TimerTask() {                                                            //ЗАПУСКАЕМ НОВЫЙ ТАЙМЕР
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        changePos();
                    }
                });
            }
        },0,20);

    }

    public void changePos(){
        bluePlanetX += 1.5;                                                                           //ДВИЖЕНИЕ ВПРАВО переделать на функцию
        if(bluePlanet.getX() > screenWidth) {
            bluePlanet.animate().scaleX(1.0f).scaleY(1.0f).setDuration(0);
            bluePlanetX = -300.0f;
            bluePlanetY = (float)Math.floor(Math.random() * (screenHeight - bluePlanet.getHeight()));
        }
        bluePlanet.setX(bluePlanetX);
        bluePlanet.setY(bluePlanetY);

        orangePlanetX += 2.5;
        if(orangePlanet.getX() > screenWidth) {
            orangePlanet.animate().scaleX(1.0f).scaleY(1.0f).setDuration(0);
            orangePlanetX = -300.0f;
            orangePlanetY = (float)Math.floor(Math.random() * (screenHeight - orangePlanet.getHeight()));
        }
        orangePlanet.setX(orangePlanetX);
        orangePlanet.setY(orangePlanetY);

        redPlanetX += 3.5;
        if(redPlanet.getX() > screenWidth) {
            redPlanet.animate().scaleX(1.0f).scaleY(1.0f).setDuration(0);
            redPlanetX = -300.0f;
            redPlanetY = (float)Math.floor(Math.random() * (screenHeight - redPlanet.getHeight()));
        }
        redPlanet.setX(redPlanetX);
        redPlanet.setY(redPlanetY);

        greenPlanetX -= 1.5;                                                                          //ДВИЖЕНИЕ ВЛЕВО переделать на функцию
        if(greenPlanet.getX() + greenPlanet.getWidth() < 0) {
            greenPlanet.animate().scaleX(1.0f).scaleY(1.0f).setDuration(0);
            greenPlanetX = screenWidth;
            greenPlanetY = (float)Math.floor(Math.random() * (screenHeight - greenPlanet.getHeight()));
        }
        greenPlanet.setX(greenPlanetX);
        greenPlanet.setY(greenPlanetY);

        pinkPlanetX -= 2.5;
        if(pinkPlanet.getX() + pinkPlanet.getWidth() < 0) {
            pinkPlanet.animate().scaleX(1.0f).scaleY(1.0f).setDuration(0);
            pinkPlanetX = screenWidth;
            pinkPlanetY = (float)Math.floor(Math.random() * (screenHeight - pinkPlanet.getHeight()));
        }
        pinkPlanet.setX(pinkPlanetX);
        pinkPlanet.setY(pinkPlanetY);

        violetPlanetX -= 3.5;
        if(violetPlanet.getX() + violetPlanet.getWidth() < 0) {
            violetPlanet.animate().scaleX(1.0f).scaleY(1.0f).setDuration(0);
            violetPlanetX = screenWidth;
            violetPlanetY = (float)Math.floor(Math.random() * (screenHeight - violetPlanet.getHeight()));
        }
        violetPlanet.setX(violetPlanetX);
        violetPlanet.setY(violetPlanetY);

    }

    public void moveToMenu(View view) {                                                             //ВЫХОД В МЕНЮ
        startActivity(moveToMenuIntent);
    }

    public void planetAnimation (ImageView planetType) {                                            //ФУНКЦИЯ АНИМАЦИИ ПО КЛИКУ
        planetType.animate().rotationBy(1800).scaleXBy(0.3f).scaleYBy(0.3f).setDuration(2000);
        cClickSound.start();
    }

    public void blueClick(View view) {
        planetAnimation(bluePlanet);
    }

    public void greenClick(View view) {
        planetAnimation(greenPlanet);
    }

    public void orangeClick(View view) {
        planetAnimation(orangePlanet);
    }

    public void pinkClick(View view) {
        planetAnimation(pinkPlanet);
    }

    public void redClick(View view) {
        planetAnimation(redPlanet);
    }

    public void violetClick(View view) {
        planetAnimation(violetPlanet);
    }


    @Override
    public void onPause() {
        super.onPause();
        cModeMusic.stop();
    }

    @Override
    public void onResume() {
        super.onResume();
        cModeMusic.start();
    }

}

