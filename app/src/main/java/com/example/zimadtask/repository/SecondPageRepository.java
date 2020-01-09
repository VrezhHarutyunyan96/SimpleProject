package com.example.zimadtask.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.zimadtask.model.ResponseModel;
import com.example.zimadtask.retrofit.ApiService;
import com.example.zimadtask.retrofit.RetrofitHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondPageRepository {

    private ApiService apiService;

    public SecondPageRepository() {
        apiService = RetrofitHandler.getRetrofitInstance().create(ApiService.class);
    }

    public LiveData<ResponseModel> getSecondPageContent() {
        final MutableLiveData<ResponseModel> data = new MutableLiveData<>();
        apiService.getSecondPageData()
                .enqueue(new Callback<ResponseModel>() {


                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
