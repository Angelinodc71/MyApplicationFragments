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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplicationfragments.model.NoticiaEverything;
import com.example.myapplicationfragments.viewModel.PrincipalViewModel;


public class VerNoticiaFragment extends Fragment {

    PrincipalViewModel principalViewModel;

    TextView tituloTextView, authorTextView, contentTextView;
    ImageView imageView;

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
        authorTextView = view.findViewById(R.id.author);
        contentTextView = view.findViewById(R.id.content);
        imageView = view.findViewById(R.id.image);

        principalViewModel.noticiaSeleccionada.observe(getViewLifecycleOwner(), new Observer<NoticiaEverything>() {
            @Override
            public void onChanged (final NoticiaEverything noticiaEverything) {
                if (noticiaEverything == null) return;

                tituloTextView.setText(noticiaEverything.title);
                authorTextView.setText(noticiaEverything.author);
                Glide.with(requireActivity()).load(noticiaEverything.urlToImage).into(imageView);
                contentTextView.setText(noticiaEverything.content);
            }
        });
    }
}
