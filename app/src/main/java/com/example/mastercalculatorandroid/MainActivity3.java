package com.example.mastercalculatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText monthlyInvestment, expectedReturn, timePeriod;
    ImageView backButton;
    TextView totalInterest, totalAmount, totalPayable;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initBinding();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateSIP();
            }
        });
    }

    private void initBinding() {
        monthlyInvestment = findViewById(R.id.monthlyInvest);
        expectedReturn = findViewById(R.id.returnValue);
        timePeriod = findViewById(R.id.timePeriod);
        calculateButton = findViewById(R.id.calculateValue);
        totalAmount = findViewById(R.id.totalInvested);
        totalInterest = findViewById(R.id.totalReturns);
        totalPayable = findViewById(R.id.totalValue);
        backButton = findViewById(R.id.backButton1);
    }

    private void calculateSIP() {
        String amount = monthlyInvestment.getText().toString();
        String interest = expectedReturn.getText().toString();
        String year = timePeriod.getText().toString();

        if (amount.isEmpty()) {
            monthlyInvestment.setError("Enter Your Amount");
            return;
        } else if (interest.isEmpty()) {
            expectedReturn.setError("Enter Your Interest");
            return;
        } else if (year.isEmpty()) {
            timePeriod.setError("Enter Your Year");
            return;
        }

        try {
            double amount1 = Double.parseDouble(amount);
            double interest1 = Double.parseDouble(interest);
            double year1 = Double.parseDouble(year);

            double monthlyRate = interest1 / 12 / 100;
            double numberOfPayments = year1 * 12;

            // Correcting the formula for SIP calculation
            double sipAmount = amount1 * ((Math.pow(1 + monthlyRate, numberOfPayments) - 1) / monthlyRate) * (1 + monthlyRate);

            double totalInvested = amount1 * numberOfPayments;
            double totalReturns = sipAmount * numberOfPayments - totalInvested;
            double totalValue = sipAmount * numberOfPayments;

            totalAmount.setText(String.format("%.2f", totalInvested));
            totalInterest.setText(String.format("%.2f", totalReturns));
            totalPayable.setText(String.format("%.2f", totalValue));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

}
