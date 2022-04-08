package org.insideranken.npcottner.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Education extends AppCompatActivity {
    TextView tvFirstCollege;
    TextView tvSecondCollege;
    Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        tvFirstCollege = findViewById(R.id.tvFirstCollege);
        tvSecondCollege = findViewById(R.id.tvSecondCollege);
        btnBackToHome = findViewById(R.id.btnBackToHome);

        tvFirstCollege.setText("St.Charles Community College" +
                               "\nAugust 2016 to February 2019" +
                               "\nPursued an Associates of Applied Science in Graphic Design, " +
                "Business Administration, and Law Enforcement ");
        tvSecondCollege.setText("Ranken Technical College" + "\nAugust 2020 to Present" +
                                "\nPursuing an Associates of Technology in Application and Web Development");

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