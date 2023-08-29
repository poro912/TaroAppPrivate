package com.AITaro.taro.SideItem;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.AITaro.taro.databinding.ActivitySettingStoreBinding;

public class Setting_StoreActivity extends AppCompatActivity {

    private ActivitySettingStoreBinding bindingSetting;
    Intent getIntentData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingSetting = ActivitySettingStoreBinding.inflate(getLayoutInflater());
        setContentView(bindingSetting.getRoot());

        getIntentData = getIntent();
        visibleData();
        backBtn();

    }//endOfClass

    private void visibleData() {
        if (getIntentData.hasExtra("setting")) {
            bindingSetting.settingGrid.setVisibility(View.VISIBLE);
            bindingSetting.storeGrid.setVisibility(View.GONE);
        } else if (getIntentData.hasExtra("store")) {
            bindingSetting.settingGrid.setVisibility(View.GONE);
            bindingSetting.storeGrid.setVisibility(View.VISIBLE);
        }
    }

    private void backBtn() {
        bindingSetting.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}