package com.example.myapplicationfragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {
AppBarConfiguration appBarConfiguration;

    public InicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.drawer1Fragment, R.id.drawer2Fragment
//        )
//                .setDrawerLayout(drawer)
//                .build();
        return inflater.inflate(R.layout.fragment_menu_inicio, container, false);
    }
}
