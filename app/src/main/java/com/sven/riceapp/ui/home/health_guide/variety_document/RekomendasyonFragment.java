package com.sven.riceapp.ui.home.health_guide.variety_document;

import static android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.sven.riceapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RekomendasyonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RekomendasyonFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RekomendasyonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RekomendasyonFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RekomendasyonFragment newInstance(String param1, String param2) {
        RekomendasyonFragment fragment = new RekomendasyonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ArrayList<String> recommendation = null;
    private TextView textView, textView1;
    private Typeface typeface;
    private TableLayout tableLayout, tableLayout2, tableLayout3;
    private TableRow tableRow;
    private String message;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tableLayout = inflater.inflate(R.layout.fragment_rekomendasyon, container,
                true).findViewById(R.id.table);
        tableLayout2 = inflater.inflate(R.layout.fragment_rekomendasyon, container,
                true).findViewById(R.id.table2);
        tableLayout3 = inflater.inflate(R.layout.fragment_rekomendasyon, container,
                true).findViewById(R.id.table3);
        if(tableLayout.getChildCount()!=0){
            tableLayout.removeAllViews();
        }
        if(tableLayout2.getChildCount()!=0){
            tableLayout2.removeAllViews();
        }
        if(tableLayout3.getChildCount()!=0){
            tableLayout3.removeAllViews();
        }
        message = requireActivity().getIntent().getExtras().getString("message");

        recommendation = new ArrayList<>();
        assignData();
        readDocuments();

        for(int i = 0; i < recommendation.size(); i++){
            assignData();
            tableApperance();
            textApperance();
            if (message.equals("Variety")){
                if (i < 18){
                    textView.setText(recommendation.set(i, recommendation.get(i)));
                    i+=1;
                    textView1.setText(recommendation.set(i, recommendation.get(i)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Land")){
                if (i+18 < 40){
                    if(i+18 == 18 || i+18 == 24 || i+18 == 29 || i+18 == 36 || i+18 == 38){
                        textView.setText(recommendation.set(i+18, recommendation.get(i+18)));
                        i+=1;
                    }else {
                        textView.setText(" ");
                    }
                    textView1.setText(recommendation.set(i+18, recommendation.get(i+18)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Planting")){
                if (i+40< 78){
                    if(i+40 == 40){
                        textView.setText(recommendation.set(i+40, recommendation.get(i+40)));
                        i+=1;
                    }else if (i+40 >= 45 && i+40 <= 55){
                        textView.setText(recommendation.set(i+40, recommendation.get(i+40)));
                        i+=1;
                    }else if (i+40 >= 66){
                        textView.setText(recommendation.set(i+40, recommendation.get(i+40)));
                        i+=1;
                    } else {
                        textView.setText(" ");
                    }
                    textView1.setText(recommendation.set(i+40, recommendation.get(i+40)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Nutrient")){
                if (i+78 < 172){
                    if(i+78 == 78 || i+78 == 80 || i+78 == 84 || i+78 == 90 || i+78 == 92 || i+78 == 94 || i+78 == 113 || i+78 == 124 || i+78 == 141 || i+78 == 150){
                        textView.setText(recommendation.set(i+78, recommendation.get(i+78)));
                        i+=1;
                    }else {
                        textView.setText(" ");
                    }
                    textView1.setText(recommendation.set(i+78, recommendation.get(i+78)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Water")){
                if (i+172 < 188){
                    if(i+172 == 172 || i+172 == 175 || i+172 == 177 || i+172 == 179 || i+172 == 181 || i+172 == 185){
                        textView.setText(recommendation.set(i+172, recommendation.get(i+172)));
                        i+=1;
                    }else {
                        textView.setText(" ");
                    }
                    textView1.setText(recommendation.set(i+172, recommendation.get(i+172)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Pest")){
                if (i+188 < 196){
                    textView.setText(recommendation.set(i+188, recommendation.get(i+188)));
                    i+=1;
                    textView1.setText(recommendation.set(i+188, recommendation.get(i+188)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Harvest")){
                if (i+196 < 210){
                    if(i+196 == 196 || i+196 == 200 || i+196 == 202 || i+196 == 205){
                        textView.setText(recommendation.set(i+196, recommendation.get(i+196)));
                        i+=1;
                    }else {
                        textView.setText(" ");
                    }
                    textView1.setText(recommendation.set(i+196, recommendation.get(i+196)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }

        }

        return inflater.inflate(R.layout.fragment_rekomendasyon, container, false);
    }

    private void assignData(){
        textView = new TextView(getActivity());
        textView1 = new TextView(getActivity());
        tableRow = new TableRow(getActivity());
    }

    private void tableApperance(){
        tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
    }

    private void textApperance(){
        typeface = Typeface.createFromAsset(this.requireActivity().getAssets(),
                "font/ArialTh.ttf");
        textView.setLayoutParams(new TableRow.LayoutParams(90,
                TableRow.LayoutParams.WRAP_CONTENT));
        textView1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        textView.setTypeface(typeface);
        textView1.setTypeface(typeface);
        textView.setTextSize(15);
        textView1.setTextSize(15);
        textView.setLineSpacing(0, 1.5F);
        textView1.setLineSpacing(0, 1.5F);
        textView1.setPadding(0,0,0,12);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                textView1.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
                textView.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);
            }
        }
    }

    private void readDocuments(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(requireActivity().getAssets().open("Recommendation.txt")));
            // do reading, usually loop until end of file reading
            String mLine;
            int i = 0;
            while ((mLine = reader.readLine()) != null) {
                //process line
                recommendation.add(i, mLine);
                i += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
