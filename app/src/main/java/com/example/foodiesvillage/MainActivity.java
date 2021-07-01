package com.example.foodiesvillage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation logoAnim, textAnim;
    ImageView logoImg;
    TextView logoTxt;
    private static int SPLASH_SCREEN = 5500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //removing status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, (WindowManager.LayoutParams.FLAG_FULLSCREEN));

        //Animation part
        logoAnim = AnimationUtils.loadAnimation(this, R.anim.logo_anim);
        textAnim = AnimationUtils.loadAnimation(this, R.anim.text_anima);

        logoImg = findViewById(R.id.logo);
        logoTxt = findViewById(R.id.logo_text);

        logoImg.setAnimation(logoAnim);
        logoTxt.setAnimation(textAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, BottomNav.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);



    }
}