package com.sven.riceapp.ui.home.fertilizer_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sven.riceapp.HomeActivity;
import com.sven.riceapp.R;

import java.util.Objects;

public class FertilizerCalculatorActivity extends AppCompatActivity {

    private EditText hectareArea;
    private Button buttonEnter, close;
    private TextView firstApply, secondApply, thirdApply;
    private RelativeLayout layout, relativeLayout;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_fertilizer_calculator);
        setLayoutInvisible();
        findId();

        buttonEnter.setOnClickListener(v -> {
            setLayoutVisible();
            String hectareInput = hectareArea.getText().toString();
            String day = getIntent().getExtras().getString("Days");
            String season = getIntent().getExtras().getString("Season");

            int hectareNumber  = Integer.parseInt(hectareInput);
            int daydayday = Integer.parseInt(day);
            int dayday = daydayday-65;

            if (hectareInput.isEmpty() && hectareNumber == 0){
                Toast.makeText(FertilizerCalculatorActivity.this, "Please enter the hectare size", Toast.LENGTH_LONG).show();
            }else {
                if (season.equals("Dry")){
                    int diammoniumPhosphate = 2 * hectareNumber;
                    int ammoniumPhosphate = 1 * hectareNumber;
                    int potash = 1 * hectareNumber;
                    int ammoniumSulfate = 4 * hectareNumber;
                    int ammo = 3 * hectareNumber;
                    int total = diammoniumPhosphate+ammoniumPhosphate+potash+ammoniumSulfate;
                    int one = dayday/3;
                    int two = one + one;
                    int three = two + one;
                    firstApply.setText("First Top Dressing ("+one+" Days)\n    "+diammoniumPhosphate+" sacks of (18-46-0) Diammonium Phosphate\n    "+ammoniumPhosphate+" sacks of (16-20-0) Ammonium Phosphate\n");
                    secondApply.setText("Second Top Dressing ("+two+" Days)\n    "+potash+" sacks of (0-0-60) Potash\n    "+ammo+" sacks of (21-0-0) Ammonium Sulfate\n");
                    thirdApply.setText("Third Top Dressing ("+three+" Days)\n    "+ammo+" sacks of (21-0-0) Ammonium Sulfate\n\nTotal bags: "+total+"\n\n");
                }else{
                    int diammoniumPhosphate = 2 * hectareNumber;
                    int diamm = 1 * hectareNumber;
                    int potash = 1 * hectareNumber;
                    int urea = 3 * hectareNumber;
                    int one = dayday/3;
                    int two = one+one;
                    int three = two + one;
                    int total = diammoniumPhosphate+diamm+potash+urea;

                    firstApply.setText("First Top Dressing ("+one+" Days)\n    "+diammoniumPhosphate+" sacks of (18-46-0) Diammonium Phosphate\n");
                    secondApply.setText("Second Top Dressing ("+two+" Days)\n    "+diamm+ " sacks of (18-46-0) Diammonium Phosphate\n    "+potash+" sacks of (0-0-60) Potash\n");
                    thirdApply.setText("Third Top Dressing ("+three+" Days)\n    "+urea+" sacks of (46-0-0) Urea\n\nTotal bags: "+total+"\n\n");
                }

//                int firstSulfateResult = 2 * hectareNumber;
//                int firstCompleteResult = 3 * hectareNumber;
//                int secondCompleteResult = 2 * hectareNumber;
//                int thirdSulfateResult = 3 * hectareNumber;
//                int totalBags = firstSulfateResult+firstCompleteResult+secondCompleteResult+thirdSulfateResult+hectareNumber+hectareNumber;

//                Toast.makeText(FertilizerCalculatorActivity.this, "Scroll UP to see details", Toast.LENGTH_LONG).show();
//                firstApply.setText("Total sacks/bags: "+totalBags+
//                        "\n\nFirst Top Dressing (15 Days)\n"+firstSulfateResult+" sacks - Ammonium Sulfate (21-0-0)\n"
//                        +firstCompleteResult+" sacks - Complete (14-14-14)");
//                secondApply.setText("Second Top Dressing (15-29 Days)\n"+hectareNumber+" sacks - Ammonium Sulfate (21-0-0)\n"
//                        +secondCompleteResult+" sacks - Complete (14-14-14)\n"
//                        +hectareNumber+" sacks - Ammonium Phosphate (16-20-0)");
//                thirdApply.setText("Third Top Dressing (30-35 Days)\n"+thirdSulfateResult+" sacks - Ammonium Sulfate (21-0-0)\n\n\n\n");
//
            }
        });

        close.setOnClickListener(v -> {
            setLayoutInvisible();
            layout.setBackgroundResource(0);
        });

    }

    private void findId(){
        buttonEnter = findViewById(R.id.btn_Calculate);
        hectareArea = findViewById(R.id.et_Hectare);
        firstApply = findViewById(R.id.tv_firstApplied);
        secondApply = findViewById(R.id.tv_secondApplied);
        thirdApply = findViewById(R.id.tv_thirdApplied);
        close = findViewById(R.id.close);
        layout = findViewById(R.id.layoutfert);
    }

    private void setLayoutInvisible(){
        relativeLayout = findViewById(R.id.hideSheet);
        if (relativeLayout.getVisibility() == View.VISIBLE) {
            relativeLayout.setVisibility(View.GONE);
        }
    }
    public void setLayoutVisible() {
        relativeLayout = findViewById(R.id.hideSheet);
        if (relativeLayout.getVisibility() == View.GONE) {
            relativeLayout.setVisibility(View.VISIBLE);
        }
    }


}