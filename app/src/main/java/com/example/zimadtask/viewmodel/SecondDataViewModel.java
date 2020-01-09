package com.example.zimadtask.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.zimadtask.model.ResponseModel;
import com.example.zimadtask.repository.SecondPageRepository;

public class SecondDataViewModel extends AndroidViewModel {
    private SecondPageRepository secondPageRepository;
    private LiveData<ResponseModel> responseLiveData;

    public SecondDataViewModel(@NonNull Application application) {
        super(application);

        secondPageRepository = new SecondPageRepository();
        this.responseLiveData = secondPageRepository.getSecondPageContent();
    }

    public LiveData<ResponseModel> getResponseLiveData() {
        return responseLiveData;
    }
}
