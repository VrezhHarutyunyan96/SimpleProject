package com.example.zimadtask.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.zimadtask.model.ResponseModel;
import com.example.zimadtask.repository.FirstPageRepository;

public class FirstDataVIewModel extends AndroidViewModel {

    private FirstPageRepository firstPageRepository;
    private LiveData<ResponseModel> responseLiveData;

    public FirstDataVIewModel(@NonNull Application application) {
        super(application);

        firstPageRepository = new FirstPageRepository();
        this.responseLiveData = firstPageRepository.getFirstPageContent();
    }

    public LiveData<ResponseModel> getResponseLiveData() {
        return responseLiveData;
    }
}