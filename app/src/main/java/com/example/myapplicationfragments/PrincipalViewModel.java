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

        rellenarListaElementos();
    }

    public void rellenarListaElementos(){
        // Thread.sleep(10000);

        List<Noticia> noticias = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Noticia noticia = new Noticia();
            noticia.titulo = "Titulo:"+i;
            noticia.subtitulo = "Subtitulo:"+i;
            noticia.imagen = "Imagen:"+i;
            noticia.categoria = "Categoria:"+i;
            noticias.add(noticia);
        }
        listaNoticias.setValue(noticias);
    }

    public void establecerElementoSeleccionado(Noticia noticia) {
        noticiaSeleccionada.setValue(noticia);
    }
}
