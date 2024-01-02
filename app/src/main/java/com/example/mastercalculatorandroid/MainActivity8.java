package com.example.mastercalculatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity8 extends AppCompatActivity {
    Button submitButton;
    ImageView backButton;

    EditText inputNumber,addSquareOrHour;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
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
                String number = inputNumber.getText().toString();
                String discount = addSquareOrHour.getText().toString();

                if (number.isEmpty()) {
                    inputNumber.setError("Enter Input");

                }
                else if (discount.isEmpty()) {
                    addSquareOrHour.setError("Enter Hour Or Square");
                }
                else {
                    calculateAndDisplayResult();
                }
            }
        });
    }

    private void initBinding(){
        submitButton = findViewById(R.id.calculateSquare);
        backButton = findViewById(R.id.backButton8);

        inputNumber = findViewById(R.id.numberEntered);
        addSquareOrHour = findViewById(R.id.squareOrHour);
        result = findViewById(R.id.schoolResult);
    }


    private void calculateAndDisplayResult() {
        String inputStr = inputNumber.getText().toString();
        String squareOrHourStr = addSquareOrHour.getText().toString();

        if (inputStr.isEmpty()) {
            inputNumber.setError("Enter Input");
        } else if (squareOrHourStr.isEmpty()) {
            addSquareOrHour.setError("Enter Hour Or Square");
        } else {
            double input = Double.parseDouble(inputStr);
           double squareOrHour = Double.parseDouble(squareOrHourStr);
            double square = Math.pow(input, squareOrHour);
            result.setText(String.format("%d", (int) square));
        }
    }
}