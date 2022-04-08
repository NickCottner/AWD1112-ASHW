package org.insideranken.npcottner.bluesrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IndividualPlayer extends AppCompatActivity {
    TextView tvIndividualPlayerName;
    TextView tvIndividualPlayerNumber;
    TextView tvIndividualPlayerPosition;
    ImageView ivIndividualPlayerImage;
    Button btnIndividualReturnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_player);
        tvIndividualPlayerName = findViewById(R.id.tvIndividualPlayerName);
        tvIndividualPlayerNumber = findViewById(R.id.tvIndividualPlayerNumber);
        tvIndividualPlayerPosition = findViewById(R.id.tvIndividualPlayerPosition);
        ivIndividualPlayerImage = findViewById(R.id.ivIndividualPlayerImage);
        btnIndividualReturnHome = findViewById(R.id.btnIndividualReturnHome);

        String theName = getIntent().getStringExtra("NAME");
        String theNumber = getIntent().getStringExtra("NUMBER");
        String thePosition = getIntent().getStringExtra("POSITION");
        int theImage = getIntent().getIntExtra("IMAGE",0);

        tvIndividualPlayerName.setText(theName);
        tvIndividualPlayerPosition.setText(thePosition);
        tvIndividualPlayerNumber.setText(theNumber);
        ivIndividualPlayerImage.setImageResource(theImage);

        btnIndividualReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
}