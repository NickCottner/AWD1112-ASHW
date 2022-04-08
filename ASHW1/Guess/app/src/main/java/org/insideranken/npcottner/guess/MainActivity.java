package org.insideranken.npcottner.guess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final int MINNUM = 1;
    final int MAXNUM = 100;

    final String NGI = "Guess Is Blank.";
    final String OORGI = "Guess Must Be Between 1 and 100.";

    String badGuessInputted = "";
    int numValidGuesses;
    //int totGuesses;

    EditText etGuess;
    Button btnCalculateGuess;
    Button btnClear;
    Button btnExit;
    TextView tvResults;
    TextView tvErrors;

    public int getRandomNumber()
    {
        return (int) ((Math.random() * (100 - 1)) + 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGuess = findViewById(R.id.etGuess);
        btnCalculateGuess = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        btnExit = findViewById(R.id.btnExit);
        tvResults = findViewById(R.id.resultsTV);
        tvErrors = findViewById(R.id.errorTV);

        etGuess.requestFocus();

        btnCalculateGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guessDriver(v);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearGame(v);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitGame(v);
            }
        });
    }

    public void guessDriver(View v) {
        int guess;
        boolean retVal = false;

        if (etGuess.getText().equals("")) {
            badGuessInputted = NGI;
            retVal = true;
        }
        if (retVal) {
            buildBadOutputString();
            return;
        }
        guess = validateGuessInputted();

        if (guess == 0) {
            badGuessInputted = OORGI;
            buildBadOutputString();
            return;
        }
       String result = calculateResult(guess);

        buildGoodOutputString(guess,result);
    }

    public int validateGuessInputted() {
        int g = 0;
        badGuessInputted = "";

        g = Integer.parseInt(etGuess.getText().toString());

        if ((g < MINNUM) || (g > MAXNUM)) {
            badGuessInputted = OORGI;
            g = 0;
        }
        return g;
    }

    public String calculateResult(int g) {
        int n = getRandomNumber();
        String r = "";

        if (g < n)
        {
            r = "Guess Is To Low";
            ++numValidGuesses;
        }
        else if (g > n)
        {
            r = "Guess To High";
            ++numValidGuesses;
        }
        else
        {
            r = "You Guessed The Number!";
            ++numValidGuesses;
        }
        return  r;
    }
    public void buildGoodOutputString(int g, String r) {
        String output = "You Guessed The Correct Number of " + g + " in " + numValidGuesses +
                " guesses.";

        displayGoodOutputString(output);
    }
    public void buildBadOutputString()
    {
        String outputStr = OORGI;

        displayBadOutputString(outputStr);
    }
    public void displayGoodOutputString(String gos)
    {
        tvResults.setText(gos);
    }
    public void displayBadOutputString(String bos)
    {
        tvErrors.setText(bos);
    }
    public void clearGame(View v)
    {
        etGuess.setText("");
        tvErrors.setText("");
        tvResults.setText("");
        etGuess.requestFocus();
    }
    public void exitGame(View v)
    {
        this.finishAffinity();
    }


}
