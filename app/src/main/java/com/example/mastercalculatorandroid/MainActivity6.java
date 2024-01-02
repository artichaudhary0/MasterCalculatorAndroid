package com.example.mastercalculatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity {

    EditText loanAmount,interestRate,timePeriod;

    TextView totalInterest,totalAmount,totalPayable;
    ImageView backButton;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        initBinding();

backButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        finish();
    }
});

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String amount = loanAmount.getText().toString();
                String interest = interestRate.getText().toString();
                String year = timePeriod.getText().toString();

                if (amount.isEmpty()) {
                    loanAmount.setError("Enter Your Amount");

                }
                else if (interest.isEmpty()) {
                    interestRate.setError("Enter Your Interest");
                }
                else if (year.isEmpty()) {
                    timePeriod.setError("Enter Your Year");
                }
                else {

                    double amount1 = Double.parseDouble(loanAmount.getText().toString());
                    double interest1 = Double.parseDouble(interestRate.getText().toString());
                    double year1 = Double.parseDouble(timePeriod.getText().toString());

                    double monthlyInterestRate = (interest1/12)/100;
                    double numberOfPayments = year1 * 12;
                    double emi = amount1 * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) / ( Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
                    totalAmount.setText(String.valueOf((int) emi));
                    totalInterest.setText(String.valueOf((int)((emi*numberOfPayments)-amount1)));
                    totalPayable.setText(String.valueOf((int)(emi*numberOfPayments)));

                }

            }
        });

    }

    private void initBinding(){
        loanAmount = findViewById(R.id.amount);
        interestRate = findViewById(R.id.interest);
        timePeriod = findViewById(R.id.year);
        submitButton = findViewById(R.id.calculateEmiValue);
        totalAmount = findViewById(R.id.totalAmount);
        totalInterest = findViewById(R.id.totalInterest);
        totalPayable = findViewById(R.id.totalPayable);
        backButton = findViewById(R.id.backButton4);
    }
}