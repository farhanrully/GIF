package com.example.gif.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public TrendingRepository getApiTrending(){
        String BASE_URL = "https://api.tenor.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(TrendingRepository.class);
    }

    public ExploreRepository getApiExplore(){
        String BASE_URL = "https://api.tenor.com/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ExploreRepository.class);
    }
}
