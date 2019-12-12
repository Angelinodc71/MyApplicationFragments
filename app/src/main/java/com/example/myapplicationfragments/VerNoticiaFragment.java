package com.example.myapplicationfragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class VerNoticiaFragment extends Fragment {

    PrincipalViewModel principalViewModel;

    TextView tituloTextView, subtituloTextView, imagenTextView, categoriaTextView;

    public VerNoticiaFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ver_noticia, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        principalViewModel = ViewModelProviders.of(requireActivity()).get(PrincipalViewModel.class);

        tituloTextView = view.findViewById(R.id.title);
        subtituloTextView = view.findViewById(R.id.subtitle);
        imagenTextView = view.findViewById(R.id.image);
        categoriaTextView = view.findViewById(R.id.category);

        principalViewModel.noticiaSeleccionada.observe(getViewLifecycleOwner(), new Observer<Noticia>() {
            @Override
            public void onChanged (final Noticia noticia) {
                if (noticia == null) return;

                tituloTextView.setText(noticia.titulo);
                subtituloTextView.setText(noticia.subtitulo);
                imagenTextView.setText(noticia.imagen);
                categoriaTextView.setText(noticia.categoria);
            }
        });
    }
}
