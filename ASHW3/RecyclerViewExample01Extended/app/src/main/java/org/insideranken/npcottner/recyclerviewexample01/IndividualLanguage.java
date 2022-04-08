package org.insideranken.npcottner.recyclerviewexample01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class IndividualLanguage extends AppCompatActivity {
    TextView tvIndLanguageName;
    TextView tvIndLanguageYear;
    TextView tvIndLanguageDescription;
    ImageView ivIndLanguageImage;
    Button btnReturnHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_language);

        String theName = getIntent().getStringExtra("NAME");
        String theYear = getIntent().getStringExtra("YEAR");
        String theDescription = getIntent().getStringExtra("DESCRIPTION");
        int theImage = getIntent().getIntExtra("IMAGE", 0);

        tvIndLanguageName = findViewById(R.id.tvIndLanguageName);
        tvIndLanguageYear = findViewById(R.id.tvIndLanguageYear);
        tvIndLanguageDescription = findViewById(R.id.tvIndLanguageDescription);
        ivIndLanguageImage = findViewById(R.id.ivIndLanguageImage);
        btnReturnHome = findViewById(R.id.btnReturnHome);

        tvIndLanguageName.setText(theName);
        tvIndLanguageYear.setText(theYear);
        tvIndLanguageDescription.setText(theDescription);
        ivIndLanguageImage.setImageResource(theImage);

        btnReturnHome.setOnClickListener(new View.OnClickListener() {
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
