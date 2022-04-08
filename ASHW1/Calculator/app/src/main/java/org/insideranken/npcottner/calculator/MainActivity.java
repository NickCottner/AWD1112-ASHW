package org.insideranken.npcottner.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    final double MINNUM = 0;
    final double MAXNUM = 100;
    final String NNI = "No Number Inputted.";
    final String NDBZ = "Illegal Attempt to Divide By 0";
    final String OORNI = "Number Must Be Between 0 and 100";

    String badNumInputted = "";

    EditText etFirstNum;
    String selectedSymbol;
    EditText etSecondNum;
    Button btnCalculate;
    Button btnClear;
    Button btnExit;
    TextView resultsTv;
    TextView errorsTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNum = findViewById(R.id.etFirstNum);
        etSecondNum = findViewById(R.id.etSecondNum);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnClear = findViewById(R.id.btnClear);
        btnExit = findViewById(R.id.btnExit);
        resultsTv = findViewById(R.id.resultsTv);
        errorsTv = findViewById(R.id.errorsTV);
        etFirstNum.requestFocus();

        Spinner spinnerSymbols = findViewById(R.id.mathSymbols);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.mathSymbolsHINT,
                        android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSymbols.setAdapter(adapter);
        spinnerSymbols.setOnItemSelectedListener(this);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDriver(v);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculations(v);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitCalculator(v);
            }
        });
    }

    @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
        {
            String selectedSymbol = parent.getItemAtPosition(position).toString();

        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        public void calculateDriver(View v)
        {
        String symbol = selectedSymbol;
        int numOne = 0;
        int numTwo = 0;
        int result = calculateTheNumbers(numOne, numTwo);
        boolean retVal = false;

        if(etFirstNum.getText().equals(""))
        {
            badNumInputted = NNI;
            retVal = true;
        }
        if(etSecondNum.getText().equals(""))
        {
            badNumInputted = NNI;
            retVal = true;
        }
        if (retVal)
        {
            buildBadOutputString();
            return;
        }
        numOne = validateNumOneInputted();

        if (numOne == 0)
        {
            badNumInputted = OORNI;
            buildBadOutputString();
            return;
        }
        numTwo = validateNumTwoInputted();

        if(numTwo == 0)
        {
            badNumInputted = OORNI;
            buildBadOutputString();
            return;
        }

        buildGoodOutputString(numOne, numTwo, result);
    }
    public int validateNumOneInputted()
    {
        int fn = 0;
        badNumInputted = "";

        fn = Integer.parseInt(etFirstNum.getText().toString());

        if ((fn < MINNUM) || (fn > MAXNUM))
        {
            badNumInputted = OORNI;
            fn = 0;
        }
        return fn;
    }
    public int validateNumTwoInputted()
    {
        int sn = 0;
        badNumInputted = "";

        sn = Integer.parseInt((etSecondNum.getText().toString()));

        if((sn < MINNUM) || (sn > MAXNUM))
        {
            badNumInputted = OORNI;
            sn = 0;
        }
        return sn;
    }
    public int calculateTheNumbers(int fn, int sn)
    {
        int calculation = 0;
        if (selectedSymbol.trim().equals("+"))
        {
             calculation = fn + sn;
        }
        else if (selectedSymbol.trim().equals("-"))
        {
            calculation = fn - sn;
        }
        else if (selectedSymbol.trim().equals("*"))
        {
            calculation = fn * sn;
        }
        else if (selectedSymbol.trim().equals("/"))
        {
            if (sn != 0)
            {
                calculation = fn / sn;
            }
            else if(sn == 0)
            {
                callTheToast(NDBZ);
            }
        }
        else if (selectedSymbol.trim().equals("%"))
        {
            calculation = fn % sn;
        }
        return calculation;
    }
    public void buildGoodOutputString(int fn, int sn, int calculation)
    {
        DecimalFormat pattern = new DecimalFormat("##0.00");

        String output = fn + selectedSymbol + sn + "= " + pattern.format(calculation);

        displayCalculation(output);
    }
    public void buildBadOutputString()
    {
        String output = badNumInputted + "\n" + badNumInputted;

        displayBadOutput(output);
    }
    public void displayCalculation(String o)
    {
        resultsTv.setText(o);
    }
    public void displayBadOutput(String os)
    {
        errorsTv.setText(os);
    }
    public void clearCalculations(View v)
    {
        etFirstNum.setText("");
        etSecondNum.setText("");
        selectedSymbol.trim().equals("+");
        resultsTv.setText("");
        errorsTv.setText("");
        etFirstNum.requestFocus();
    }
    public void exitCalculator(View v)
    {
        this.finishAffinity();
    }
    public void callTheToast(String os)
    {
        Toast t;
        t = Toast.makeText(this, NDBZ, Toast.LENGTH_LONG);
        t.show();
    }





}
