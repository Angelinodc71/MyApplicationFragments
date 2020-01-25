package com.example.myapplicationfragments;


import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageCommentFragment extends Fragment {


    public MessageCommentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_message_comment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView1= view.findViewById(R.id.textView1);
        textView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(requireContext()).setTitle("Interaccion dejar pulsado")
                        .setMessage("\n\nAquí podria bloquear un comentario o darle me gusta")
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
                        .setMessage("\n\nAquí podria bloquear un perfil o otras funcionalidades")
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
                        .setMessage("\n\nAquí podria bloquear un comentario o darle me gusta")
                        .setCancelable(true)
                        .create()
                        .show();
                return false;
            }
        });
        ImageView imageView2= view.findViewById(R.id.imageView2);
        imageView2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                new AlertDialog.Builder(requireContext()).setTitle("Interaccion dejar pulsado")
                        .setMessage("\n\nAquí podria bloquear un perfil o otras funcionalidades")
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
                        .setMessage("\n\nAquí podria bloquear un comentario o darle me gusta")
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
                        .setMessage("\n\nAquí podria bloquear un perfil o otras funcionalidades")
                        .setCancelable(true)
                        .create()
                        .show();
                return false;
            }
        });
    }
}
