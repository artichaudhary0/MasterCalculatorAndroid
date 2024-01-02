package com.example.mastercalculatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    EditText amount,returnAmount,time;
    Button submitButton;
    ImageView backButton;
    TextView totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
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

                double amount1 = Double.parseDouble(amount.getText().toString());
                double interest1 = Double.parseDouble(returnAmount.getText().toString());
                double year1 = Double.parseDouble(time.getText().toString());


                double b = 1 + ((interest1 / 100) * (year1));
                totalAmount.setText(String.valueOf((int)(amount1*b)));

            }
        });
    }
    private void initBinding(){
        amount = findViewById(R.id.principalAmount);
        returnAmount = findViewById(R.id.interestReturn);
        time = findViewById(R.id.timePeriod);
        submitButton = findViewById(R.id.calculateInterest);
        totalAmount = findViewById(R.id.totalInterestAmount);
        backButton = findViewById(R.id.backButton2);
    }

}