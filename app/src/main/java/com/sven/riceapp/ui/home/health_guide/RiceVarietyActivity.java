package com.sven.riceapp.ui.home.health_guide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.sven.riceapp.R;
import com.sven.riceapp.ui.home.health_guide.variety_document.Crop;
import com.sven.riceapp.ui.home.health_guide.variety_document.Harvest;
import com.sven.riceapp.ui.home.health_guide.variety_document.Land;
import com.sven.riceapp.ui.home.health_guide.variety_document.Nutrient;
import com.sven.riceapp.ui.home.health_guide.variety_document.Pest;
import com.sven.riceapp.ui.home.health_guide.variety_document.Variety;
import com.sven.riceapp.ui.home.health_guide.variety_document.Water;

public class RiceVarietyActivity extends AppCompatActivity {

//    ListView listView;
    Button button1,button2,button3,button4,button5,button6,button7;
//    String [] arrayManagement = {"PAGPILI NG BINHI AT BARAYTI","PAGHAHANDA NG LUPA",
//            "PAGTATANIM","PAMAMAHALA NG SUSTANSIYA","PAMAMAHALA NG TUBIG","PAMAMAHALA NG PESTE",
//            "PAG-AANI"};

    private void findId(){
        button1 = findViewById(R.id.seemore);
        button2 = findViewById(R.id.seemore2);
        button3 = findViewById(R.id.seemore3);
        button4 = findViewById(R.id.seemore4);
        button5 = findViewById(R.id.seemore5);
        button6 = findViewById(R.id.seemore6);
        button7 = findViewById(R.id.seemore7);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_variety);
//        listView = findViewById(R.id.lv_list_view);
        findId();
        button1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Variety.class);
            startActivity(intent);
        });
        button2.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Land.class);
            startActivity(intent);
        });
        button3.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Crop.class);
            startActivity(intent);
        });
        button4.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Nutrient.class);
            startActivity(intent);
        });
        button5.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Water.class);
            startActivity(intent);
        });
        button6.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Pest.class);
            startActivity(intent);
        });
        button7.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Harvest.class);
            startActivity(intent);
        });
//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,arrayManagement);

//        listView.setAdapter(arrayAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String text = " ";
//                try {
//                    InputStream is = getAssets().open(position+".txt");
//                    int size = is.available();
//                    byte [] buffer = new byte[size];
//                    is.read(buffer);
//                    is.close();
//                    text = new String(buffer);
//                }catch (IOException ex){
//                    ex.printStackTrace();
//                }
//                Intent intent = new Intent(getApplicationContext(), SelectionDetails.class);
//                intent.putExtra("Message",text);
//                startActivity(intent);
//            }
//        });
    }


}