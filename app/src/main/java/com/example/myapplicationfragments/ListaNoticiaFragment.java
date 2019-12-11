package com.example.myapplicationfragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ListaNoticiaFragment extends androidx.fragment.app.Fragment {

    PrincipalViewModel principalViewModel;
    NavController navController;
    NoticiasAdapter noticiasAdapter;


    public ListaNoticiaFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        principalViewModel = ViewModelProviders.of(requireActivity()).get(PrincipalViewModel.class);
        navController = Navigation.findNavController(view);

        RecyclerView noticiasRecyclerView = view.findViewById(R.id.recyclerview_noticias);
        noticiasRecyclerView.addItemDecoration(new DividerItemDecoration(noticiasRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        noticiasAdapter = new NoticiasAdapter();
        noticiasRecyclerView.setAdapter(noticiasAdapter);

        principalViewModel.listaNoticias.observe(getViewLifecycleOwner(), new Observer<List<Noticia>>() {
            @Override
            public void onChanged(List<Noticia> noticias) {
                noticiasAdapter.establecerLista(noticias);
            }
        });
    }

    class NoticiasAdapter extends  RecyclerView.Adapter<NoticiasAdapter.NoticiaViewHolder> {
        private List<Noticia> noticiasArriba = null;

        @NonNull
        @Override
        public NoticiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new NoticiaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_noticia, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull NoticiaViewHolder holder, int position) {
            final Noticia noticia = noticiasArriba.get(position);

            holder.tituloTextView.setText(noticia.titulo);
            holder.subtituloTextView.setText(noticia.subtitulo);
            holder.imagenTextView.setText(noticia.imagen);
            holder.categoriaTextView.setText(noticia.categoria);



            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    principalViewModel.establecerNoticiaSeleccionada(noticia);
                    navController.navigate(R.id.detalleElementoFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return noticiasArriba == null ? 0 : noticiasArriba.size();
        }

        public void establecerLista(List<Noticia> noticias){
            this.noticiasArriba = noticias;
            notifyDataSetChanged();
        }

        class NoticiaViewHolder extends RecyclerView.ViewHolder {

            TextView tituloTextView, categoriaTextView, imagenTextView, subtituloTextView;

            NoticiaViewHolder(@NonNull View itemView) {
                super(itemView);
                tituloTextView = itemView.findViewById(R.id.textview_titulo);
                subtituloTextView = itemView.findViewById(R.id.textview_subtitulo);
                imagenTextView = itemView.findViewById(R.id.textview_imagen);
                categoriaTextView = itemView.findViewById(R.id.textview_categoria);
            }
        }
    }
}