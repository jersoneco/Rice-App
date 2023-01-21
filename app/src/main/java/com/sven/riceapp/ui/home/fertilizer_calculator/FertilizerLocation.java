package com.sven.riceapp.ui.home.fertilizer_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.sven.riceapp.R;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FertilizerLocation extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fertilizer_location);
        spinner = findViewById(R.id.location);
        Button button = findViewById(R.id.locationButton);
        String[] baranGays = new String[32];
        get_Barangay(baranGays);

        button.setOnClickListener(v -> {
            if (spinner.getSelectedItem().toString().equals("Select Barangay")) {
                Toast.makeText(getApplicationContext(), "Please select barangay.", Toast.LENGTH_LONG).show();
            } else {
//                if (spinner.getSelectedItem().toString().equals("VALENCIA CITY")){
                Intent intent = new Intent(getApplicationContext(), FertilizerSelect.class);
                intent.putExtra("location", spinner.getSelectedItem().toString());
                startActivity(intent);
//                }else {
//                    Toast.makeText(getApplicationContext(), "No data available.", Toast.LENGTH_LONG).show();
//                }
            }
        });

    }

    public void get_Barangay(String[] baranGays){

//        try {
//            File file = new File("assets/ValenciaBarangay");
//            Scanner scanner = new Scanner(file);
//            int rot = 0;
//            while (scanner.hasNextLine()) {
//                String data = scanner.nextLine();
//                baranGays[rot] = data;
//                rot+=1;
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("ValenciaBarangay")));
            // do reading, usually loop until end of file reading
            String mLine;
            int i = 0;
            while ((mLine = reader.readLine()) != null) {
                //process line
                baranGays[i] = mLine;
                i += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, baranGays);
        spinner.setAdapter(adapter);
    }

}