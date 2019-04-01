package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private EditText kroner;
    private String type;
    private TextView currency;
    private List<String> list1= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Views
        kroner = (EditText) findViewById(R.id.kroner);
        currency = (TextView) findViewById(R.id.currency);

        // Default value
        kroner.setText("0.0");

        spinner = (Spinner) findViewById(R.id.spinner);
        list1.add("Choose currency");
        list1.add("USD");
        list1.add("EUR");
        list1.add("AUD");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        // Add item selected listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int pos,
                                       long id) {

                // Get input text
                type = kroner.getText().toString();

                if (pos == 1) {
                    USD();
                } else if (pos == 2) {
                    EUR();
                } else if (pos == 3) {
                    AUD();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void USD() {
        double us = Double.valueOf(type)*0.152137;
        currency.setText(String.format("%.2f", us));
    }

    private void EUR() {
        double eur = Double.valueOf(type)*0.133988287;
        currency.setText(String.format("%.2f", eur));
    }

    private void AUD() {
        double aud = Double.valueOf(type)*0.2146662;
        currency.setText(String.format("%.2f", aud));
    }


}