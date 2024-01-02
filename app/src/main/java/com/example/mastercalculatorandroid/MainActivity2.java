package com.example.mastercalculatorandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    ImageView backButton;
    LinearLayout MutualFundScreen,InterestScreen,DiscountScreen,EMIScreen,SchoolResultScreen,SquareOrHourScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initBinding();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        MutualFundScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        InterestScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        DiscountScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);
            }
        });

        EMIScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity6.class);
                startActivity(intent);
            }
        });

        SchoolResultScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity7.class);
                startActivity(intent);
            }
        });

        SquareOrHourScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity2.this,MainActivity8.class);
                startActivity(intent);
            }
        });


    }

    private void initBinding(){
        MutualFundScreen = findViewById(R.id.mutualFund);
        InterestScreen = findViewById(R.id.interest);
        DiscountScreen = findViewById(R.id.discount);
        EMIScreen = findViewById(R.id.emi);
        SchoolResultScreen = findViewById(R.id.schoolResult);
        SquareOrHourScreen = findViewById(R.id.squareOrHour);
        backButton = findViewById(R.id.BackButton1);
    }
}