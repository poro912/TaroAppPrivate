package com.AITaro.taro.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.AITaro.taro.R;
import com.StoreSettingPackage.BuyBackGroundFragment;
import com.StoreSettingPackage.BuyCardFragment;
import com.StoreSettingPackage.BuySpreadFragment;
import org.jetbrains.annotations.NotNull;

public class ExFragmentAdapter extends FragmentStateAdapter {
    Intent getData;

    public ExFragmentAdapter(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle, Context context) {
        super(fragmentManager, lifecycle);


    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new BuyCardFragment();
            case 1:
                return new BuySpreadFragment();
            case 2:
                return new BuyBackGroundFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
