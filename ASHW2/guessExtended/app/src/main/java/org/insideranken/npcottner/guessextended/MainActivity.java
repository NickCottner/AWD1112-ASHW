package org.insideranken.npcottner.guessextended;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final int MINNUM = 1;
    final int MAXNUM = 100;
    final int MAXWOW = 5;
    final int MAXAMATEUR = 10;


    final String RN = "Your Rank is Novice";
    final String RA = "Your Rank is Amateur";
    final String RW = "Your Rank is Wow";

    final String GTL = "Your Guess Is To Low.";
    final String GTH = "Your Guess Is To High.";
    final String CG = "You Guessed the Number!";

    final String NGI = "No Guess Inputted";
    final String OORGI = "Guess Inputted Is Out of Range.\n" +
            "Guess Must Be Between (" + MINNUM + " - " + MAXNUM + ") ";

    EditText etGuess;
    TextView tvResults;
    TextView tvError;
    TextView tvRank;
    Button btnCalculate;
    Button btnClear;
    Button btnRank;
    Button btnTotals;
    Button btnStartNew;

    int totRN = 0;
    int totRA = 0;
    int totRW = 0;
    double guess = 0.0;

    int numGuesses;
    String rankStr = "";
    double guessNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGuess = findViewById(R.id.etGuess);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        btnRank = findViewById(R.id.btnRank);
        btnStartNew = findViewById(R.id.btnStartNewGame);
        btnTotals = findViewById(R.id.btnTotals);
        tvResults = findViewById(R.id.tvResults);
        tvError = findViewById(R.id.tvError);
        tvRank = findViewById(R.id.tvRank);
        etGuess.requestFocus();

        int sn = (int) ((Math.random() * (MAXNUM - MINNUM)) + MINNUM);
        btnRank.setEnabled(false);

        btnCalculate.setOnClickListener(v -> {
            boolean retVal = validateGuess();
            if(retVal)
            {
               guessNumber = calculateResult(guess,sn);
            }
        });
        btnClear.setOnClickListener(v -> clearAll());

        btnRank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle rankExtras = new Bundle();
                rankExtras.putString("Rank", rankStr);

                Intent rankIntent = new Intent(getApplicationContext(),
                        rankActivity.class);
                rankIntent.putExtras(rankExtras);
                startActivity(rankIntent);
            }
        });
        btnTotals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle totExtras = new Bundle();
                totExtras.putInt("totRN", totRN);
                totExtras.putInt("totRA", totRA);
                totExtras.putInt("totRW", totRW);

                Intent totIntent = new Intent(getApplicationContext(),
                        totalsActivity.class);

                totIntent.putExtras(totExtras);
                startActivity(totIntent);
            }
        });
        btnStartNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
    }
    public boolean validateGuess()
    {
        try {
            guess = Integer.parseInt(etGuess.getText().toString());
            if ((guess < MINNUM) || (guess > MAXNUM))
            {
                guess = 0;
                etGuess.setText("");
                etGuess.requestFocus();
                throw new Exception();
            }
            else if (TextUtils.isEmpty(etGuess.getText()))
            {
                guess = 0;
                etGuess.setText("");
                etGuess.requestFocus();
                throw new NumberFormatException();
            }
            return true;
        }
        catch (NumberFormatException nfe)
        {
            tvError.setText(NGI);
            Toast toast = Toast.makeText(getApplicationContext(), NGI, Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        catch (Exception e)
        {
            tvError.setText(OORGI);
            Toast toast = Toast.makeText(getApplicationContext(),
                    OORGI,
                    Toast.LENGTH_LONG);
            toast.show();

            return false;
        }

    }
    public double calculateResult(double g, int sn)
    {
        if (g < sn)
        {
            tvResults.setText(GTL);
            Toast toast = Toast.makeText(getApplicationContext(), GTL, Toast.LENGTH_LONG);
            toast.show();
            numGuesses++;
            etGuess.setText("");
            etGuess.requestFocus();
        }
        if (g > sn)
        {
            tvResults.setText(GTH);
            Toast toast = Toast.makeText(getApplicationContext(), GTH, Toast.LENGTH_LONG);
            toast.show();
            numGuesses++;
            etGuess.setText("");
            etGuess.requestFocus();
        }
        if(g == sn)
        {
            tvResults.setText(CG);
            Toast toast = Toast.makeText(getApplicationContext(), CG, Toast.LENGTH_LONG);
            toast.show();
            rankStr = calculateRank();
            btnRank.setEnabled(true);
            numGuesses++;
        }
        return g;
    }
    public String calculateRank()
    {

        if (guessNumber <= MAXWOW)
        {
            tvRank.setText(RW);
            Toast toast = Toast.makeText(getApplicationContext(), RW, Toast.LENGTH_LONG);
            toast.show();
            ++totRW;
        }
        else if((guessNumber > MAXWOW) && (guessNumber < MAXAMATEUR))
        {
            tvRank.setText(RA);
            Toast toast = Toast.makeText(getApplicationContext(), RA, Toast.LENGTH_LONG);
            toast.show();
            ++totRA;
        }
        else
        {
            tvRank.setText(RN);
            Toast toast = Toast.makeText(getApplicationContext(), RN, Toast.LENGTH_LONG);
            toast.show();
            ++totRN;
        }
        return null;
    }
    public void clearAll()
    {
        etGuess.setText("");
        tvResults.setText("");
        tvError.setText("");
        
    }

}