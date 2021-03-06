package com.example.myapplicationfragments;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.myapplicationfragments.model.NoticiaEverything;
import com.example.myapplicationfragments.viewModel.PrincipalViewModel;

import es.dmoral.toasty.Toasty;


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

        Button buttonComment= view.findViewById(R.id.btn_post_comment);buttonComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toasty.warning(getContext(), "De momento no se pueden añadir comentarios", Toast.LENGTH_SHORT, true).show();
            }
        });

        TextView textView1= view.findViewById(R.id.textView1);
        textView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(requireContext()).setTitle("Interaccion dejar pulsado")
                        .setMessage("\n\nAquí podria responder al comentario")
                        .setCancelable(true)
                        .create()
                        .show();
                return false;
            }
        });
        TextView textView2= view.findViewById(R.id.textView2);
        textView2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(requireContext()).setTitle("Interaccion dejar pulsado")
                        .setMessage("\n\nAquí podria responder al comentario")
                        .setCancelable(true)
                        .create()
                        .show();
                return false;
            }
        });
        TextView textView3= view.findViewById(R.id.textView3);
        textView3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(requireContext()).setTitle("Interaccion dejar pulsado")
                        .setMessage("\n\nAquí podria responder al comentario")
                        .setCancelable(true)
                        .create()
                        .show();
                return false;
            }
        });

        ImageView imageView1= view.findViewById(R.id.imageView1);
        imageView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(requireContext()).setTitle("Interaccion dejar pulsado")
                        .setMessage("\n\nAquí podria acceder a un perfil")
                        .setCancelable(true)
                        .create()
                        .show();
                return false;
            }
        });

        ImageView imageView2 = view.findViewById(R.id.imageView2);
        imageView2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(requireContext()).setTitle("Interaccion dejar pulsado")
                        .setMessage("\n\nAquí podria acceder a un perfil")
                        .setCancelable(true)
                        .create()
                        .show();
                return false;
            }
        });

        ImageView imageView3= view.findViewById(R.id.imageView3);
        imageView3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(requireContext()).setTitle("Interaccion dejar pulsado")
                        .setMessage("\n\nAquí podria acceder a un perfil")
                        .setCancelable(true)
                        .create()
                        .show();
                return false;
            }
        });



    }
}
