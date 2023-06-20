package com.StoreSettingPackage;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.AITaro.taro.databinding.ActivityStoreBinding;

public class StoreActivity extends AppCompatActivity {
    private ActivityStoreBinding bindingStore;
    Intent getiData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingStore = ActivityStoreBinding.inflate(getLayoutInflater());
        setContentView(bindingStore.getRoot());

       getiData = getIntent();

       getFragment();
    }

    void getFragment() {
        if (getiData.hasExtra("buyCard")) {
            bindingStore.chText.setText("카드구매");
        } else if (getiData.hasExtra("buySpread")) {
            bindingStore.chText.setText("스프레드 구매");
        } else if (getiData.hasExtra("buybg")) {
            bindingStore.chText.setText("배경표지 구매");
        }
    }
}