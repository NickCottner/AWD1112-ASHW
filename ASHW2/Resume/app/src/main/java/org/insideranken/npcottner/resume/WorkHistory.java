package org.insideranken.npcottner.resume;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;
public class WorkHistory extends AppCompatActivity {
    TextView tvFirstWork;
    TextView tvSecondWork;
    Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work_history);

        tvFirstWork = findViewById(R.id.tvFirstWork);
        tvSecondWork = findViewById(R.id.tvSecondWork);
        btnBackToHome = findViewById(R.id.btnBackToHome);;

        tvFirstWork.setText("Taco Bell" + "\nSep 2015 to June 2016" +
                "\nStarted As A Team Member, Promoted To Shift Lead " +
                "\nBased on A Recommendation From Another Shift Lead" +
                "\n\nAs A Team Member We Were The First Face People Hear/See When " +
                "Coming To The Restaurant" +
                "\n\nAs a Shift Lead We Were Responsible For Managing The Restaurant " +
                "\nWhen The AM/GM Was Not There, Basically Run Great Shifts and Meet " +
                "Company Standards" +"\nBy Taking Responsibility and " +
                "Ownership of The Restaurant"
        );
        tvSecondWork.setText("City of O'Fallon" + "\nMarch 2020 to Present" +
                "\nSeasonal Landscape Worker" +
                "\nCurrently In The Wait For My Third Season To Start" +
                "\nWe Assist The Full Time Horticultural Specialists In The Maintenance " +
                "of Landscapes Around The City");

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