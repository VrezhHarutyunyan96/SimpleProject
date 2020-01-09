package com.example.zimadtask.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.zimadtask.R;
import com.example.zimadtask.constants.AppConstants;
import com.example.zimadtask.view.fragment.FirstFragment;
import com.example.zimadtask.view.fragment.SecondFragment;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    // views
    private TabLayout tabLayout;
    //Object types
    private Fragment firstFragment;
    private Fragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViewsAndObjects();
        setupTabLayout();
        onTabSelected();
    }

    // Initialization of views and objects
    private void initViewsAndObjects() {
        tabLayout = findViewById(R.id.tabLayout);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
    }

    private void setupTabLayout() {
        tabLayout.addTab(tabLayout.newTab().setText("ONE"));
        tabLayout.addTab(tabLayout.newTab().setText("TWO"));
    }

    private void onTabSelected() {

        createFragment(R.id.fragmentContainer, firstFragment);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        // show first fragment
                        createFragment(R.id.fragmentContainer, firstFragment);
                        break;
                    case 1:
                        // show second fragment
                        createFragment(R.id.fragmentContainer, secondFragment);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(AppConstants.ACTIVITY_STATE,tabLayout.getSelectedTabPosition());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        int index = savedInstanceState.getInt(AppConstants.ACTIVITY_STATE);
        TabLayout.Tab tab = tabLayout.getTabAt(index);
        if (index != 0) {
            tab.select();
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void createFragment(int resId, Fragment fragment) {
        Fragment createdFragment = getSupportFragmentManager()
                .findFragmentByTag(fragment.getClass().getName());
        if (createdFragment == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(resId, fragment, fragment.getClass().getName())
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(resId, createdFragment, createdFragment.getClass().getName())
                    .addToBackStack(null)
                    .commit();
        }
    }

}

