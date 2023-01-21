package com.sven.riceapp.ui.home.fertilizer_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sven.riceapp.R;

public class FertilizerSelect extends AppCompatActivity {

    private Button dry, rainy;
    private Spinner days;
    private TextView place;

    private void findId(){
        dry = findViewById(R.id.dry);
        rainy = findViewById(R.id.rainy);
        days = findViewById(R.id.days);
        place = findViewById(R.id.place);
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_select);

        findId();

        String places = getIntent().getExtras().getString("location");
        place.setText("Barangay " + places);

        String[] day = {"100","105","110","115","120"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, day);
        days.setAdapter(adapter);
//        String day2 = days.getSelectedItem().toString();

        dry.setOnClickListener(v -> {
            String day2 = days.getSelectedItem().toString();
            if (day2.isEmpty()){
                Toast.makeText(FertilizerSelect.this, "Please Select Days of Maturity!", Toast.LENGTH_LONG).show();
            } else {
                String season = "Rainy";
                Intent intent = new Intent(getApplicationContext(), FertilizerCalculatorActivity.class);
                intent.putExtra("Days", days.getSelectedItem().toString());
                intent.putExtra("Season", season);
                startActivity(intent);
            }
        });

        rainy.setOnClickListener(v -> {
            String day2 = days.getSelectedItem().toString();
            if (day2.isEmpty()){
                Toast.makeText(FertilizerSelect.this, "Please Select Days of Maturity!", Toast.LENGTH_LONG).show();
            } else {
                String season = "Dry";
                Intent intent = new Intent(getApplicationContext(), FertilizerCalculatorActivity.class);
                intent.putExtra("Days", days.getSelectedItem().toString());
                intent.putExtra("Season", season);
                startActivity(intent);
            }
        });
    }


}