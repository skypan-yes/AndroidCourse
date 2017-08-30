package com.skypan.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by skypan on 2017/8/27.
 */

public class LifeCycleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Log.d("LifeCycle","----onCreate----");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","----onStart----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","----onResume----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","----onPause----");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","----onStop----");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","----onRestart----");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","----onDestroy----");
    }
}
