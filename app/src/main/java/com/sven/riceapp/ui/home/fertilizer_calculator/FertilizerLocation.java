package com.sven.riceapp.ui.home.fertilizer_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.sven.riceapp.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FertilizerLocation extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_location);
        spinner = findViewById(R.id.location);
        Button button = findViewById(R.id.locationButton);

//        try {
//            File file = new File("assets/location.txt");
//            Scanner scanner = new Scanner(file);
//            int rot = 0;
//            while (scanner.hasNextLine()) {
//                String data = scanner.nextLine();
//                places[rot] = data;
//                rot++;
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        String[] places = {"Select Location", "VALENCIA CITY","MALAYBALAY CITY"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, places);
        spinner.setAdapter(adapter);

        button.setOnClickListener(v -> {
            if (spinner.getSelectedItem().toString().equals("Select Location")) {
                Toast.makeText(getApplicationContext(), "Please select location.", Toast.LENGTH_LONG).show();

            }else {
                if (spinner.getSelectedItem().toString().equals("VALENCIA CITY")){
                    Intent intent = new Intent(getApplicationContext(), FertilizerSelect.class);
                    intent.putExtra("location", spinner.getSelectedItem().toString());
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(), "No data available.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}