package com.JeffTorres.primeraappv1.servicios;

import com.JeffTorres.primeraappv1.Entidades.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServicioPokemon
{
    @GET("pokemons/n00194025")
    Call<List<Pokemon>> allRepos();

    @POST("pokemons/n00194025/crear")
    Call<Pokemon> create(@Body Pokemon poke);
}
