package com.Integration.aitaroapp.Page;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityStoreBinding;

public class StoreActivity extends AppCompatActivity {
    private ActivityStoreBinding _bindingStore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _bindingStore = ActivityStoreBinding.inflate(getLayoutInflater());
        setContentView(_bindingStore.getRoot());


    }
}