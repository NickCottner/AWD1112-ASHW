package org.insideranken.npcottner.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextTip;
    EditText editTextBillAmount;
    EditText editTextTotal;
    SeekBar seekBarTipAmount;
    Toast t;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextBillAmount = findViewById(R.id.editTextBillAmount);
        editTextTip = findViewById(R.id.editTextTip);
        editTextTotal = findViewById(R.id.editTextTotal);
        seekBarTipAmount = findViewById(R.id.seekBarTipAmount);

        seekBarTipAmount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                calculateTotals(seekBarTipAmount.getProgress());
            }
        });
    }
    void calculateTotals(int percentage)
    {
        double billAmount =
                Double.valueOf(editTextBillAmount.getText().toString());
        double tip = billAmount * (percentage / 100.0);
        double total = billAmount + tip;

        editTextTip.setText(String.format("$%.2f", tip));
        editTextTotal.setText(String.format("$%.2f", total));

        t = Toast.makeText(getApplicationContext(), "The Current Tip Percentage Is: " +
                          percentage + "%", Toast.LENGTH_LONG);
        t.show();
    }
}