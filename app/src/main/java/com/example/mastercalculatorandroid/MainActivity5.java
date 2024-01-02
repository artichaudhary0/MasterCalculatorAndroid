package com.example.mastercalculatorandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    EditText priceValue,discountValue;
    Button submitButton;
    ImageView backButton;
    TextView priceAfterDiscount,savedPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
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
                String price = priceValue.getText().toString();
                String discount = discountValue.getText().toString();

                if (price.isEmpty()) {
                    priceValue.setError("Enter Your Amount");

                }
                else if (discount.isEmpty()) {
                    discountValue.setError("Enter Your Discount");
                }
                else {

                    double amount1 = Double.parseDouble(priceValue.getText().toString());
                    double interest1 = Double.parseDouble(discountValue.getText().toString());

                    double  a = ((amount1) * (interest1)) / 100;

                    priceAfterDiscount.setText(String.valueOf((int)(amount1-a)));
                    savedPrice.setText(String.valueOf((int) a));

                }
            }
        });
    }

    private void initBinding(){
        priceValue = findViewById(R.id.priceValue);
        discountValue = findViewById(R.id.discountPrice);
        submitButton = findViewById(R.id.calculateDiscount);
        priceAfterDiscount = findViewById(R.id.totalPriceAfterDiscount);
        savedPrice = findViewById(R.id.totalSavePrice);
        backButton = findViewById(R.id.backButton3);
    }
}