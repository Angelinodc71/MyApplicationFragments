package com.example.myapplicationfragments.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplicationfragments.api.*;
import com.example.myapplicationfragments.model.*;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

 public class PrincipalViewModel extends AndroidViewModel {

    public MutableLiveData<List<NoticiaEverything>> listaNoticias = new MutableLiveData<>();
    public MutableLiveData<NoticiaEverything> noticiaSeleccionada = new MutableLiveData<>();

    public PrincipalViewModel(@NonNull Application application) {
        super(application);

        rellenarListaNoticias();
    }

    public void rellenarListaNoticias(){

        NoticiasApiModule.noticiasApi.obtenerTodo("841ec8cefc034fa78da9adba54bb224a", "sports").enqueue(new Callback<EverythingResponse>() {
            @Override
            public void onResponse(Call<EverythingResponse> call, Response<EverythingResponse> response) {
                if(response != null && response.body() != null) {
                    listaNoticias.postValue(response.body().articles);
                } else {
                    Log.e("ABCD", "Error obteniendo respuesta de la api");
                }
            }

            @Override
            public void onFailure(Call<EverythingResponse> call, Throwable t) {}
        });
    }

    public void establecerNoticiaSeleccionada(NoticiaEverything noticiaEverything) {
        noticiaSeleccionada.setValue(noticiaEverything);
    }



}
