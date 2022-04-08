package org.insideranken.npcottner.recyclerviewexample01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Screen extends AppCompatActivity {
    Handler ssHandler;
    Runnable ssRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ssHandler = new Handler();

        ssRunnable = new Runnable() {
            @Override
            public void run() {
                Intent ssIntent = new Intent(Splash_Screen.this, MainActivity.class);

                startActivity(ssIntent);
                finish();
            }
        };

        ssHandler.postDelayed(ssRunnable, 2000);
    }
}