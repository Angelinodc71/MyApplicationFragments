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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplicationfragments.model.NoticiaEverything;

import java.util.List;


public class CategoryTwoFragment extends androidx.fragment.app.Fragment {

    PrincipalViewModel principalViewModel;
    NavController navController;
    NoticiasAdapter noticiasAdapter;


    public CategoryTwoFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category_two, container, false);
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

        principalViewModel.listaNoticias.observe(getViewLifecycleOwner(), new Observer<List<NoticiaEverything>>() {
            @Override
            public void onChanged(List<NoticiaEverything> noticiaEverythings) {
                noticiasAdapter.establecerLista(noticiaEverythings);
                // de lo que te da el response o de noticias ??
            }
        });
    }

    class NoticiasAdapter extends  RecyclerView.Adapter<NoticiasAdapter.NoticiaViewHolder> {
        private List<NoticiaEverything> noticiasArriba = null;

        @NonNull
        @Override
        public NoticiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new NoticiaViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_noticia, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull NoticiaViewHolder holder, int position) {
            final NoticiaEverything noticiaEverything = noticiasArriba.get(position);

            holder.tituloTextView.setText(noticiaEverything.title);
            holder.authorTextView.setText(noticiaEverything.author);
            Glide.with(requireActivity()).load(noticiaEverything.urlToImage).into(holder.imageView);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    principalViewModel.establecerNoticiaSeleccionada(noticiaEverything);
                    navController.navigate(R.id.detalleElementoFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return noticiasArriba == null ? 0 : noticiasArriba.size();
        }

        public void establecerLista(List<NoticiaEverything> noticiaEverythings){
            this.noticiasArriba = noticiaEverythings;
            notifyDataSetChanged();
        }

        class NoticiaViewHolder extends RecyclerView.ViewHolder {

            TextView tituloTextView, authorTextView;
            ImageView imageView;

            NoticiaViewHolder(@NonNull View itemView) {
                super(itemView);
                tituloTextView = itemView.findViewById(R.id.textview_titulo);
                authorTextView = itemView.findViewById(R.id.textview_author);
                imageView = itemView.findViewById(R.id.image_view);
            }
        }
    }
}
