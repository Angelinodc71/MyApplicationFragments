package com.example.myapplicationfragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class PrincipalViewModel extends AndroidViewModel {

    MutableLiveData<List<Noticia>> listaNoticias = new MutableLiveData<>();
    MutableLiveData<Noticia> noticiaSeleccionada = new MutableLiveData<>();

    public PrincipalViewModel(@NonNull Application application) {
        super(application);

        rellenarListaNoticias();
    }

    public void rellenarListaNoticias(){
        // Thread.sleep(10000);

        List<Noticia> noticias = new ArrayList<>();
        for (int i = 1; i < 51; i++) {
            Noticia noticia = new Noticia();
            noticia.titulo = "Titulo:"+i;
            noticia.subtitulo = "Subtitulo:"+i;
            noticia.imagen = "Imagen:"+i;
            noticia.categoria = "Categoria:"+i;
            noticias.add(noticia);
        }
        listaNoticias.setValue(noticias);
    }

    public void establecerNoticiaSeleccionada(Noticia noticia) {
        noticiaSeleccionada.setValue(noticia);
    }
}
