package com.android.victor.finalbolasrebotando;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    static int statusBar, width, height;

    Pelota[] pelota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout layout = findViewById(R.id.layoutBola);
        DisplayMetrics display = this.getBaseContext().getResources().getDisplayMetrics();

        width = display.widthPixels;
        height = display.heightPixels;

        float[] velocidad = {9,-9,3,-2,-4,-3,2,-4,6,5,-6,-5,7};
        pelota = new Pelota[5];

        for(int i = 0; i<pelota.length;i++){

            pelota[i] = new Pelota(velocidad[new Random().nextInt(4)],velocidad[new Random().nextInt(4)]);
            pelota[i].bola = new ImageView(getApplicationContext());

            layout.addView(pelota[i].bola);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) pelota[i].bola.getLayoutParams();

            params.height = 100;
            params.width = 100;

            pelota[i].bola.setX(height/8*2);
            pelota[i].bola.setY(width/8*2);

            pelota[i].bola.setLayoutParams(params);
            pelota[i].bola.setImageResource(R.drawable.bola);
        }
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                for(int i =0; i<pelota.length; i++) {
                    pelota[i].movimientoPelota(5,5);
                }
            }
        };

        Timer timer = new Timer();
        timer.schedule(tt, 0,30);
    }
}

