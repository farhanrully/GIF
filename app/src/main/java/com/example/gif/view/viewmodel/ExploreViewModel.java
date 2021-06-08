package com.example.gif.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gif.model.explore.ExploreItem;
import com.example.gif.model.explore.ExploreResponse;
import com.example.gif.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExploreViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<ExploreItem>> listExplore = new MutableLiveData<>();

    public void setExplore(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiExplore().getExplore().enqueue(new Callback<ExploreResponse>() {
            @Override
            public void onResponse(Call<ExploreResponse> call, Response<ExploreResponse> response) {
                ExploreResponse exploreResponse = response.body();
                if (exploreResponse != null && exploreResponse.getTags() != null){
                    ArrayList<ExploreItem> exploreItems = exploreResponse.getTags();
                    listExplore.postValue(exploreItems);
                }
            }

            @Override
            public void onFailure(Call<ExploreResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<ExploreItem>> getExploreResult(){
        return listExplore;
    }
}
