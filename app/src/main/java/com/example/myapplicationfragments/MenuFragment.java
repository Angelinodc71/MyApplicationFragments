package com.example.myapplicationfragments;


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
public class MenuFragment extends Fragment {


    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button buttonHelp = view.findViewById(R.id.btn_help);
        buttonHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.helpFragment);

            }
        });
        Button buttonAboutUs = view.findViewById(R.id.btn_about);
        buttonAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.aboutUsFragment);
            }
        });
        Button buttonGeneral = view.findViewById(R.id.btn_general);
        buttonGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Este fragment aún no esta disponible", Toast.LENGTH_SHORT, true).show();
            }
        });
        Button buttonNotificacion = view.findViewById(R.id.btn_notifications);
        buttonNotificacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Este fragment aún no esta disponible", Toast.LENGTH_SHORT, true).show();
            }
        });
        Button buttonBloqueado = view.findViewById(R.id.btn_blocked);
        buttonBloqueado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Este fragment aún no esta disponible", Toast.LENGTH_SHORT, true).show();
            }
        });
        Button buttonHistorial = view.findViewById(R.id.btn_history);
        buttonHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.info(getContext(), "Este fragment aún no esta disponible", Toast.LENGTH_SHORT, true).show();
            }
        });
    }
}
