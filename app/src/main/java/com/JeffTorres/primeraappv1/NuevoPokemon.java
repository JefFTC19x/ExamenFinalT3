package com.JeffTorres.primeraappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.JeffTorres.primeraappv1.Entidades.Pokemon;
import com.JeffTorres.primeraappv1.servicios.ServicioPokemon;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NuevoPokemon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_pokemon);



        Button agregarPokemon = findViewById(R.id.crearpokemon);
        agregarPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EditText nombrePoke =findViewById(R.id.nombrepokemon);
                EditText tipoPoke =findViewById(R.id.tipopokemon);
                EditText linkPoke =findViewById(R.id.linkpokemon);
                EditText latitudPoke =findViewById(R.id.latitudpokemon);
                EditText longitudPoke =findViewById(R.id.longitudpokemon);

                String vnombre =String.valueOf(nombrePoke.getText());
                String vtipo =String.valueOf(tipoPoke.getText());
                String vlink =String.valueOf(linkPoke.getText());
                String val1 = String.valueOf(latitudPoke.getText());
                String val2 = String.valueOf(longitudPoke.getText());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://upn.lumenes.tk/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                ServicioPokemon servicio =retrofit.create(ServicioPokemon.class);
                Pokemon agregarpokemon = new Pokemon();
                agregarpokemon.setNombrePokemon(vnombre);
                agregarpokemon.setTipoPokemon(vtipo);
                agregarpokemon.setLinkPokemon(vlink);
                agregarpokemon.setLatitud(Float.parseFloat(val1));
                agregarpokemon.setLongitud(Float.parseFloat(val2));

                Log.i("Main"," Latitud"+agregarpokemon.getLatitud());

                servicio.create(agregarpokemon).enqueue(new Callback<Pokemon>()
                {
                    @Override
                    public void onResponse(Call<Pokemon> call, Response<Pokemon> response)
                    {
                        Log.i("MAIN_APP",new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<Pokemon> call, Throwable t)
                    {
                        Log.i("MAIN_APP","No hay conexion");
                    }
                });
            }
        });




    }
}