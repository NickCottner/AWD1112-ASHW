package org.insideranken.npcottner.guessextended;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class rankActivity extends AppCompatActivity {

    Button btnBackToHome;
    TextView tvRankTitle;
    ImageView ivRank;
    Drawable drawable = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        String rankStr = "";

        btnBackToHome = findViewById(R.id.btnBackToHome);
        ivRank = findViewById(R.id.ivRank);
        tvRankTitle = findViewById(R.id.tvRankTitle);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        if(extras != null)
        {
            if(extras.containsKey("rankStr"))
            {
                rankStr = extras.getString("rankStr", "");
            }
        }
        switch (rankStr)
        {
            case "RW":
                tvRankTitle.setText("You Are Wow");
                drawable = getResources().getDrawable(R.drawable.wow);
                break;

            case "RA":
                tvRankTitle.setText("You Are Amateur");
                drawable = getResources().getDrawable(R.drawable.amateur);
                break;

            case "RN":
                tvRankTitle.setText("You Are Novice");
                drawable = getResources().getDrawable(R.drawable.novice);
                break;

            default:
                tvRankTitle.setText("Which Rank Are You?");
                drawable = getResources().getDrawable(R.drawable.rank);
                break;
        }

        ivRank.setImageDrawable(drawable);
        tvRankTitle.setText("Which Rank Are You?");



        btnBackToHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();

            }

        });
    }
}