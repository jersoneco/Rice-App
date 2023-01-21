package com.sven.riceapp.ui.home.health_guide.variety_document;

import static android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD;

import android.annotation.SuppressLint;
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
 * Use the {@link PagtatayaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagtatayaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PagtatayaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PagtatayaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PagtatayaFragment newInstance(String param1, String param2) {
        PagtatayaFragment fragment = new PagtatayaFragment();
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

    private ArrayList<String> assessment = null;
    private TextView textView, textView1;
    private Typeface typeface;
    private TableLayout tableLayout, tableLayout2, tableLayout3;
    private TableRow tableRow;
    private String message;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tableLayout = inflater.inflate(R.layout.fragment_pagtataya, container,
                true).findViewById(R.id.table);
        tableLayout2 = inflater.inflate(R.layout.fragment_pagtataya, container,
                true).findViewById(R.id.table2);
        tableLayout3 = inflater.inflate(R.layout.fragment_pagtataya, container,
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

        assessment = new ArrayList<>();
        assignData();
        readDocuments();

        for(int i = 0; i < assessment.size(); i++){
            assignData();
            tableApperance();
            textApperance();
            if (message.equals("Variety")){
                if (i < 6){
                    textView.setText(assessment.set(i, assessment.get(i)));
                    i+=1;
                    textView1.setText(assessment.set(i, assessment.get(i))+"\n");
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Land")){
                if (i+6 < 10){
                    if(i+6 == 6){
                        textView.setText(assessment.set(i+6, assessment.get(i+6)));
                        i+=1;
                    }else {
                        textView.setText(" ");
                    }
                    textView1.setText(assessment.set(i+6, assessment.get(i+6)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Planting")){
                if (i+10 < 48){
                    if(i+10 == 32 || i+10 == 33){
                        textView.setText(" ");
                    }else {
                        textView.setText(assessment.set(i+10, assessment.get(i+10)));
                        i+=1;
                    }
                    textView1.setText(assessment.set(i+10, assessment.get(i+10)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Nutrient")){
                if (i+48 < 58){
                    textView.setText(assessment.set(i+48, assessment.get(i+48)));
                    i+=1;
                    textView1.setText(assessment.set(i+48, assessment.get(i+48)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Water")){
                if (i+58 < 62){
                    textView.setText(assessment.set(i+58, assessment.get(i+58)));
                    i+=1;
                    textView1.setText(assessment.set(i+58, assessment.get(i+58)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Pest")){
                if (i+62 < 88){
                    textView.setText(assessment.set(i+62, assessment.get(i+62)));
                    i+=1;
                    textView1.setText(assessment.set(i+62, assessment.get(i+62)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }
            if (message.equals("Harvest")){
                if (i+88 < 98){
                    textView.setText(assessment.set(i+88, assessment.get(i+88)));
                    i+=1;
                    textView1.setText(assessment.set(i+88, assessment.get(i+88)));
                    tableRow.addView(textView);
                    tableRow.addView(textView1);
                    tableLayout.addView(tableRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                            TableLayout.LayoutParams.WRAP_CONTENT));
                }else {
                    break;
                }
            }

        }

        return inflater.inflate(R.layout.fragment_pagtataya, container, false);
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
                    new InputStreamReader(requireActivity().getAssets().open("Assessment.txt")));
            // do reading, usually loop until end of file reading
            String mLine;
            int i = 0;
            while ((mLine = reader.readLine()) != null) {
                //process line
                assessment.add(i, mLine);
                i += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}