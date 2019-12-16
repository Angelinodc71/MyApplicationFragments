package com.example.myapplicationfragments.api;

import com.example.myapplicationfragments.model.EverythingResponse;
import com.example.myapplicationfragments.model.TopHeadlinesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NoticiasApi {

    // consultas api
    //https://newsapi.org/v2/everything?q=bitcoin&from=2019-11-16&sortBy=publishedAt&apiKey=API_KEY


    // top-headlines
    @GET("everything/")
    Call<EverythingResponse> obtenerTodo(@Query("apiKey") String miclaveApi);


    @GET("top-headlines/")
    Call<TopHeadlinesResponse> obtenerTitulares(@Query("apiKey") String miclaveApi);


    // everything
}



// api.obtenerTitulares("Apple");