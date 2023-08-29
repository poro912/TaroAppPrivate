package com.AITaro.taro.Adapter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.StoreSettingPackage.BuyBackGroundFragment;
import com.StoreSettingPackage.BuyCardFragment;
import com.StoreSettingPackage.BuySpreadFragment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentStateAdapter{

    private final ArrayList<Fragment> mFragmentList = new ArrayList<>();
    private BuySpreadFragment buySpreadFragment;
    private BuyBackGroundFragment buyBackGroundFragment;
    private BuyCardFragment buyCardFragment;

    public FragmentAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                buyCardFragment = new BuyCardFragment();
                addFragment(buyCardFragment);
                break;

            case 1:
                buySpreadFragment = new BuySpreadFragment();
                addFragment(buySpreadFragment);
                break;

            case 2:
                buyBackGroundFragment = new BuyBackGroundFragment();
                addFragment(buyBackGroundFragment);
                break;

            default:
                return null;
        }

        return mFragmentList.get(position);
    }

    public void addFragment(Fragment fragment){
        mFragmentList.add(fragment);
    }

    @Override
    public int getItemCount() {
        return mFragmentList.size();
    }
}
