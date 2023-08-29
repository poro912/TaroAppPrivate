package com.StoreSettingPackage;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.AITaro.taro.Adapter.ExFragmentAdapter;
import com.AITaro.taro.Adapter.FragmentAdapter;
import com.AITaro.taro.R;
import com.AITaro.taro.databinding.ActivityStoreBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreActivity extends FragmentActivity {
    private ActivityStoreBinding bindingStore;
    BuyCardFragment buycardFragment;
    BuySpreadFragment buySpreadFragment;
    BuyBackGroundFragment buyBackGround;
    Intent getData;
    private TabLayout tabIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingStore = ActivityStoreBinding.inflate(getLayoutInflater());
        setContentView(bindingStore.getRoot());

        getData = getIntent();
        buycardFragment = new BuyCardFragment();
        buySpreadFragment = new BuySpreadFragment();
        buyBackGround = new BuyBackGroundFragment();
       ex();

    }

    void ex(){
        ExFragmentAdapter exFragmentAdapter = new ExFragmentAdapter(getSupportFragmentManager(), getLifecycle(), this);

        bindingStore.mainLayout.setAdapter(exFragmentAdapter);

        new TabLayoutMediator(bindingStore.storePageTabLayout, bindingStore.mainLayout, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull @NotNull TabLayout.Tab tab, int position) {
                tab.setText("TAB" + (position + 1));
            }
        }).attach();

    }

    void getFragment() {

        if (getData.hasExtra("buyCard")) {
            getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, buycardFragment).commit();
        } else if (getData.hasExtra("buySpread")) {
            getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, buySpreadFragment).commit();
        } else if (getData.hasExtra("buybg")) {
            getSupportFragmentManager().beginTransaction().add(R.id.mainLayout, buyBackGround).commit();
        }


    }

    void setTabIcon(){
        FragmentAdapter fa = new FragmentAdapter(this);

        bindingStore.mainLayout.setAdapter(fa);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(bindingStore.storePageTabLayout, bindingStore.mainLayout,
                (tab, position) -> {
                    // 탭의 텍스트를 설정합니다. 자신의 탭 제목을 설정해야 합니다.
                    tab.setText("Tab " + position);
                    tab.setIcon(R.drawable.ic_launcher_foreground);
                });

        tabLayoutMediator.attach();




    }
}