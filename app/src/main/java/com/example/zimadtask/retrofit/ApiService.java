package com.example.zimadtask.retrofit;

import com.example.zimadtask.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api.php?query=cat")
    Call<ResponseModel> getFirstPageData();

    @GET("api.php?query=dog")
    Call<ResponseModel> getSecondPageData();

}
