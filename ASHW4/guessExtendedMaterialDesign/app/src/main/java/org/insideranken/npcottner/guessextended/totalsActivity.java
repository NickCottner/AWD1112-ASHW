package org.insideranken.npcottner.guessextended;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class totalsActivity extends AppCompatActivity {
    Button btnBackToHome;
    TextView tvTotalNovices;
    TextView tvTotalAmateurs;
    TextView tvTotalWows;

    int totalNovices;
    int totalAmateurs;
    int totalWow;

    String resultNovice;
    String resultAmateur;
    String resultWow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals);

        btnBackToHome = findViewById(R.id.btnBackToHome);
        tvTotalNovices = findViewById(R.id.tvTotalNovices);
        tvTotalAmateurs = findViewById(R.id.tvTotalAmateurs);
        tvTotalWows = findViewById(R.id.tvTotalWows);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        if (extras != null)
        {
            if (extras.containsKey("totRN"))
            {
                totalNovices = extras.getInt("totRN", 0);
            }
            if (extras.containsKey("totRA"))
            {
                totalAmateurs = extras.getInt("totRA", 0);
            }
            if (extras.containsKey("totRW"))
            {
                totalWow = extras.getInt("totRW", 0);
            }
        }
        resultNovice = "Total Number of Novices: " + totalNovices;
        resultAmateur = "Total Number of Amateurs: " + totalAmateurs;
        resultWow = "Total Number of Wows: " + totalWow;

        tvTotalWows.setText(resultWow);
        tvTotalAmateurs.setText(resultAmateur);
        tvTotalNovices.setText(resultNovice);




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