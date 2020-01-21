package com.watssap.retrofit.service;

import com.watssap.model.Contato;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ContatoService {

    @POST("contato/contato")
    Call<List<Contato>> insert(@Body Contato contato);

}
