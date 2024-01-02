package com.example.mastercalculatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity7 extends AppCompatActivity {

    EditText totalMarks,totalObtainedMarks;
    Button submitButton;
    ImageView backButton;
    TextView percentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
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
                String price = totalMarks.getText().toString();
                String discount = totalObtainedMarks.getText().toString();

                if (price.isEmpty()) {
                    totalMarks.setError("Enter Your Marks");

                }
                else if (discount.isEmpty()) {
                    totalObtainedMarks.setError("Enter Your Total Marks");
                }
                else {

                    calculateAndDisplayPercentage();

                }
            }
        });
    }

    private void initBinding(){
        totalMarks = findViewById(R.id.totalMarks);
        totalObtainedMarks = findViewById(R.id.totalMarksObtained);
        submitButton = findViewById(R.id.calculate);
        percentage = findViewById(R.id.totalPercentage);
        backButton = findViewById(R.id.BackButton8);
    }
    private void calculateAndDisplayPercentage() {
        String marksStr = totalMarks.getText().toString();
        String totalMarksStr = totalObtainedMarks.getText().toString();

        if (marksStr.isEmpty()) {
            totalMarks.setError("Enter Your Marks");
            return;
        } else if (totalMarksStr.isEmpty()) {
            totalObtainedMarks.setError("Enter Your Total Marks");
            return;
        }

        try {
            double marks = Double.parseDouble(totalMarksStr);
            double total = Double.parseDouble(marksStr);

            double percentageValue = (marks / total) * 100;

            // Display the result with two decimal places
            percentage.setText(String.format("%.2f%%", percentageValue));
        } catch (NumberFormatException e) {
            // Handle if there is an issue parsing the input as doubles
            e.printStackTrace();
        }
    }


}