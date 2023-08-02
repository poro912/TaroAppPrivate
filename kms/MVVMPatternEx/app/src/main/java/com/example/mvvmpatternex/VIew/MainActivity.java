package com.example.mvvmpatternex.VIew;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import com.example.mvvmpatternex.R;
import com.example.mvvmpatternex.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bindingMain;
    ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Main_onCrete() 실행", "Main_onCrete() 실행");
        super.onCreate(savedInstanceState);

        bindingMain = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setContentView(R.layout.activity_main);


    }
}