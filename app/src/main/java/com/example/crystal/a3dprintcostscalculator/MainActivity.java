package com.example.crystal.a3dprintcostscalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private double material = 0.00125;
    private double diameter = 1.75;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked1(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton1:
                if (checked) {
                    material = 0.00125;
                }
                break;
            case R.id.radioButton2:
                if (checked) {
                    material = 0.00105;
                }
                break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButton3:
                if (checked) {
                    diameter = 1.75;
                }
                break;
            case R.id.radioButton4:
                if (checked) {
                    diameter = 3.00;
                }
                break;
        }
    }

    public void onButtonClicked(View view) {
        EditText et1 = (EditText) findViewById(R.id.editText);
        double cost = Double.parseDouble(et1.getText().toString());

        EditText et2 = (EditText) findViewById(R.id.editText2);
        double length = Double.parseDouble(et2.getText().toString());

        double radius = diameter / 2;
        double PI = 3.14159;
        double area = radius * radius * PI * 1;
        double weight = area * length * material;
        double price = (cost / 1000) * weight;

        String result = String.format(Locale.ENGLISH, "%.2f", price);
        TextView tv1 = (TextView) findViewById(R.id.textView4);
        tv1.setText(result);

        String grams = String.format(Locale.ENGLISH, "%.2f", weight);
        TextView tv2 = (TextView) findViewById(R.id.textView3);
        tv2.setText(grams);
    }
}