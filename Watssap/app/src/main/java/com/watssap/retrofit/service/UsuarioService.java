package com.watssap.retrofit.service;

import com.watssap.model.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UsuarioService {

    @POST("usuario/usuario")
    Call<List<Usuario>> insert(@Body Usuario usuario);


    @POST("usuario/login")
    Call<List<Usuario>> login(@Body Usuario usuario);
}
