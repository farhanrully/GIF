package com.example.gif.service;

import com.example.gif.model.explore.ExploreResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  ExploreRepository {
    @GET("/v1/categories?key=D6AP4CL0EGJS")
    Call<ExploreResponse> getExplore();
}
