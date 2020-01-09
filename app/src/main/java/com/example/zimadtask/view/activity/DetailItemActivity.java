package com.example.zimadtask.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimadtask.R;
import com.example.zimadtask.constants.AppConstants;
import com.squareup.picasso.Picasso;

public class DetailItemActivity extends AppCompatActivity implements View.OnClickListener {

    //view
    private ImageView imageView;
    private TextView textViewTitle;

    // object
    private String imageUrl;
    private String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);

        initViews();
        getIntentData(getIntent());
        loadData(imageUrl,title);
    }

    private void getIntentData(Intent intent) {
        if (intent != null) {
            imageUrl = intent.getStringExtra(AppConstants.DETAIL_IMAGE);
            title = intent.getStringExtra(AppConstants.DETAIL_TITLE);
        }
    }

    private void initViews() {
        imageView = findViewById(R.id.detailItemImageId);
        textViewTitle = findViewById(R.id.textTitleId);
        ConstraintLayout back = findViewById(R.id.backLayoutId);
        back.setOnClickListener(this);
    }

    private void loadData(String imageUrl,String title) {
        if (imageUrl != null && title != null) {
            Picasso
                    .with(this)
                    .load(imageUrl)
                    .into(imageView);
            textViewTitle.setText(title);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.backLayoutId) {
            handleBack();
        }
    }

    private void handleBack() {
        finish();
    }
}

