package br.com.andersonmatte.cavaleirosplayer.projeto.service;

import java.util.List;

import br.com.andersonmatte.cavaleirosplayer.projeto.entidade.Episodio;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface VideoService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.myjson.com/bins/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    Call<List<Episodio>> getEpisodios();


}
