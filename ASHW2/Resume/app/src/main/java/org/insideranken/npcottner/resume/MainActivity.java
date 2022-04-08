package org.insideranken.npcottner.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView ivHeadshot;
    Button btnEducation;
    Button btnCallMe;
    Button btnWorkHistory;
    Button btnEmailMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivHeadshot = findViewById(R.id.ivHeadshot);
        btnCallMe = findViewById(R.id.btnCallMe);
        btnEducation = findViewById(R.id.btnEducation);
        btnWorkHistory = findViewById(R.id.btnWorkHistory);
        btnEmailMe = findViewById(R.id.btnEmailMe);


        btnEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent eduIntent = new Intent(getApplicationContext(),Education.class);
                startActivity(eduIntent);

            }
        });
        btnWorkHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent whIntent = new Intent(getApplicationContext(), WorkHistory.class);
                startActivity(whIntent);
            }
        });
        btnCallMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri phoneNumber = Uri.parse("tel: 6365418849");
                Intent callMeIntent = new Intent(Intent.ACTION_DIAL, phoneNumber);
                startActivity(callMeIntent);

            }
        });
        btnEmailMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailMeIntent = new Intent(Intent.ACTION_SEND);
                emailMeIntent.setType("plain/text");

                emailMeIntent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"nicholas_cottner@insideranken.org"});
                emailMeIntent.putExtra(Intent.EXTRA_SUBJECT, "Resume Received");
                //emailMeIntent.putExtra(Intent.Extra_Text, "This is to let you know we've received
                // your resume).

            }
        });
    }
}