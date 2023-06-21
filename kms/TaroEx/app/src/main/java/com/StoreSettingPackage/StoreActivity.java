package com.StoreSettingPackage;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.AITaro.taro.R;
import com.AITaro.taro.databinding.ActivityStoreBinding;
import org.jetbrains.annotations.NotNull;

public class StoreActivity extends FragmentActivity {
    private ActivityStoreBinding bindingStore;
    buycard_Fragment buycardFragment;
    BuySpreadFragment buySpreadFragment;
    BuyBackGroundFragment buyBackGround;
    Intent getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingStore = ActivityStoreBinding.inflate(getLayoutInflater());
        setContentView(bindingStore.getRoot());

        getData = getIntent();
        buycardFragment = new buycard_Fragment();
        buySpreadFragment = new BuySpreadFragment();
        buyBackGround = new BuyBackGroundFragment();
        getFragment();
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
}