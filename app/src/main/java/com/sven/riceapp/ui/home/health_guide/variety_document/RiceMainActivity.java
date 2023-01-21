package com.sven.riceapp.ui.home.health_guide.variety_document;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.sven.riceapp.R;
import com.sven.riceapp.databinding.ActivityRiceMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RiceMainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView title, subtitle;
    ActivityRiceMainBinding binding;
    final private int [] picture = {R.drawable.rice_variety, R.drawable.landprep, R.drawable.riceplanting,
            R.drawable.nutrient, R.drawable.water, R.drawable.pest, R.drawable.harvest};
    private String message = null;
    final private String [] riceTitle = new String[7];
    final private String [] riceSubTitle = new String[8];

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRiceMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        message = getIntent().getExtras().getString("message");
        replaceFragment(new Kahalagahan_Fragment());
        getID();
        getRiceTitle(riceTitle, riceSubTitle);
        setAllContent();

        binding.bottomNavButton.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_kahalagahan:
                    replaceFragment(new Kahalagahan_Fragment());
                    break;
                case R.id.menu_pagtataya:
                    replaceFragment(new PagtatayaFragment());
                    break;
                case R.id.menu_rekomendasyon:
                    replaceFragment(new RekomendasyonFragment());
                    break;
            }
            return true;
        });
    }

    private void getID(){
        imageView = findViewById(R.id.picture);
        title = findViewById(R.id.title);
        subtitle = findViewById(R.id.key);
    }

    private void replaceFragment(Fragment fragment){
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottom_nav_view, fragment);
        fragmentTransaction.commit();
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n"})
    private void setAllContent(){
        switch (message){
            case "Variety":
                imageView.setImageDrawable(getResources().getDrawable(picture[0],
                        getApplicationContext().getTheme()));
                title.setText(riceTitle[0]);
                subtitle.setText(riceSubTitle[0]+"\nSource: PhilRice. (2020). Sistemang Palaycheck, 6-8.");
                break;
            case "Land":
                imageView.setImageDrawable(getResources().getDrawable(picture[1],
                        getApplicationContext().getTheme()));
                title.setText(riceTitle[1]);
                subtitle.setText(riceSubTitle[1]+"\nSource: PhilRice. (2020). Sistemang Palaycheck, 9-11.");
                break;
            case "Planting":
                imageView.setImageDrawable(getResources().getDrawable(picture[2],
                        getApplicationContext().getTheme()));
                title.setText(riceTitle[2]);
                subtitle.setText(riceSubTitle[2]+"\n"+riceSubTitle[3]+"\nSource: PhilRice. (2020). Sistemang Palaycheck, 12-21.");
                break;
            case "Nutrient":
                imageView.setImageDrawable(getResources().getDrawable(picture[3],
                        getApplicationContext().getTheme()));
                title.setText(riceTitle[3]);
                subtitle.setText(riceSubTitle[4]+"\nSource: PhilRice. (2020). Sistemang Palaycheck, 23-34.");
                break;
            case "Water":
                imageView.setImageDrawable(getResources().getDrawable(picture[4],
                        getApplicationContext().getTheme()));
                title.setText(riceTitle[4]);
                subtitle.setText(riceSubTitle[5]+"\nSource: PhilRice. (2020). Sistemang Palaycheck, 35-37.");
                break;
            case "Pest":
                imageView.setImageDrawable(getResources().getDrawable(picture[5],
                        getApplicationContext().getTheme()));
                title.setText(riceTitle[5]);
                subtitle.setText(riceSubTitle[6]+"\nSource: PhilRice. (2020). Sistemang Palaycheck, 38-44.");
                break;
            case "Harvest":
                imageView.setImageDrawable(getResources().getDrawable(picture[6],
                        getApplicationContext().getTheme()));
                title.setText(riceTitle[6]);
                subtitle.setText(riceSubTitle[7]+"\nSource: PhilRice. (2020). Sistemang Palaycheck, 45-47.");
                break;
        }

    }

    private void getRiceTitle(String [] riceTitle, String [] riceSubTitle){
        BufferedReader reader, reader1;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("RiceTitle.txt")));
            // do reading, usually loop until end of file reading
            String mLine;
            int i = 0;
            while ((mLine = reader.readLine()) != null) {
                //process line
                riceTitle[i] = mLine;
                i += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader1 = new BufferedReader(
                    new InputStreamReader(getAssets().open("RiceSubTitle.txt")));
            // do reading, usually loop until end of file reading
            String mLine;
            int i = 0;
            while ((mLine = reader1.readLine()) != null) {
                //process line
                riceSubTitle[i] = mLine;
                i += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}