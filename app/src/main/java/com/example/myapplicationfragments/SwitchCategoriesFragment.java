package com.example.myapplicationfragments;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;


/**
 * A simple {@link Fragment} subclass.
 */
public class SwitchCategoriesFragment extends Fragment {


    public SwitchCategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_switch_categories, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button buttonBusiness= view.findViewById(R.id.btn_business);
        buttonBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Funcionalidad aún no disponible", Toast.LENGTH_SHORT, true).show();
            }
        });

        Button buttonEntertainment= view.findViewById(R.id.btn_entertainment);
        buttonEntertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Funcionalidad aún no disponible", Toast.LENGTH_SHORT, true).show();
            }
        });

        Button buttonGeneral= view.findViewById(R.id.btn_general);
        buttonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Funcionalidad aún no disponible", Toast.LENGTH_SHORT, true).show();
            }
        });

        Button buttonHealth= view.findViewById(R.id.btn_health);
        buttonHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Funcionalidad aún no disponible", Toast.LENGTH_SHORT, true).show();
            }
        });

        Button buttonScience= view.findViewById(R.id.btn_science);
        buttonScience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Funcionalidad aún no disponible", Toast.LENGTH_SHORT, true).show();
            }
        });

        Button buttonSports= view.findViewById(R.id.btn_sports);
        buttonSports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Funcionalidad aún no disponible", Toast.LENGTH_SHORT, true).show();
            }
        });

        Button buttonTecnology= view.findViewById(R.id.btn_technology);
        buttonTecnology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Funcionalidad aún no disponible", Toast.LENGTH_SHORT, true).show();
            }
        });



    }
}
