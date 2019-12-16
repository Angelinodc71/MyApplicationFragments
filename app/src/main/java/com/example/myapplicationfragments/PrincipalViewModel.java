package com.example.myapplicationfragments;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplicationfragments.api.NoticiasApiModule;
import com.example.myapplicationfragments.model.EverythingResponse;
import com.example.myapplicationfragments.model.Noticia;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PrincipalViewModel extends AndroidViewModel {

    MutableLiveData<List<Noticia>> listaNoticias = new MutableLiveData<>();
    MutableLiveData<Noticia> noticiaSeleccionada = new MutableLiveData<>();

    public PrincipalViewModel(@NonNull Application application) {
        super(application);

        rellenarListaNoticias();
    }

    public void rellenarListaNoticias(){

        NoticiasApiModule.noticiasApi.obtenerTodo("841ec8cefc034fa78da9adba54bb224a").enqueue(new Callback<EverythingResponse>() {
            @Override
            public void onResponse(Call<EverythingResponse> call, Response<EverythingResponse> response) {
                listaNoticias.postValue(response.body().articles);
            }

            @Override
            public void onFailure(Call<EverythingResponse> call, Throwable t) {}
        });
    }

    public void establecerNoticiaSeleccionada(Noticia noticia) {
        noticiaSeleccionada.setValue(noticia);
    }
}
