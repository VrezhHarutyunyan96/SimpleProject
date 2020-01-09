package com.example.zimadtask.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zimadtask.R;
import com.example.zimadtask.model.ResponseModel;
import com.example.zimadtask.model.Result;
import com.example.zimadtask.view.adapter.RecyclerItemAdapter;
import com.example.zimadtask.viewmodel.SecondDataViewModel;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {

    // views
    private View view;
    private RecyclerView rv;
    private LinearLayoutManager layoutManager;
    private ProgressBar progressBar;
    // objct types
    private Context context;
    private RecyclerItemAdapter adapter;
    private ArrayList<Result> arrayList = new ArrayList<>();
    private SecondDataViewModel secondDataViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_second, container, false);
        context = getContext();
        initViews();
        initDataAdapter();
        initViewModel();
        getPageData();
        return view;
    }

    // Initialization of views and objects

    private void initViews() {
        rv = view.findViewById(R.id.firstDataRecyclerView);
        progressBar = view.findViewById(R.id.progress);
    }

    private void initDataAdapter() {
        layoutManager = new LinearLayoutManager(context);
        rv.setLayoutManager(layoutManager);
        adapter = new RecyclerItemAdapter(context, arrayList);
        rv.setAdapter(adapter);
    }

    private void initViewModel() {
        secondDataViewModel = ViewModelProviders.of(this).get(SecondDataViewModel.class);
    }

    private void getPageData() {
        secondDataViewModel.getResponseLiveData().observe(this, new Observer<ResponseModel>() {
            @Override
            public void onChanged(ResponseModel responseModel) {
                if (responseModel != null) {
                    progressBar.setVisibility(View.GONE);
                    List<Result> articles = responseModel.getData();
                    arrayList.addAll(articles);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

}

