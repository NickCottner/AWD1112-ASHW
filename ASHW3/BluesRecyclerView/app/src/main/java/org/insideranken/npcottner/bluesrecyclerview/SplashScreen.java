package org.insideranken.npcottner.bluesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {

    Handler mHandler;
    Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        mHandler = new Handler();

        mRunnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this,
                        MainActivity.class);

                startActivity(intent);
                finish();
            }
        };

        mHandler.postDelayed(mRunnable, 5000);

    }
}