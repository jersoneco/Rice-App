package com.sven.riceapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.sven.riceapp.R;
//import com.sven.riceapp.databinding.FragmentHomeBinding;
import com.sven.riceapp.ui.home.disease_identifier.DiseaseIdentifierActivity;
import com.sven.riceapp.ui.home.fertilizer_calculator.FertilizerCalculatorActivity;
import com.sven.riceapp.ui.home.fertilizer_calculator.FertilizerLocation;
import com.sven.riceapp.ui.home.fertilizer_calculator.FertilizerSelect;
import com.sven.riceapp.ui.home.health_guide.RiceVarietyActivity;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        LinearLayout healthGuide = root.findViewById(R.id.health_guide_home);
        LinearLayout fertilizerCalculator = root.findViewById(R.id.fertilizer_calculator_home);
        LinearLayout diseaseIdentifier = root.findViewById(R.id.disease_identifier_home);

        healthGuide.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), RiceVarietyActivity.class);
            startActivity(intent);
        });

        fertilizerCalculator.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), FertilizerLocation.class);
            startActivity(intent);
        });

        diseaseIdentifier.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), DiseaseIdentifierActivity.class);
            startActivity(intent);
        });

        return root;
    }
}