package com.StoreSettingPackage;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.AITaro.taro.R;
import com.AITaro.taro.databinding.FragmentBuyBackGroundBinding;
import com.AITaro.taro.databinding.FragmentBuySpreadBinding;
import org.jetbrains.annotations.NotNull;

public class BuyBackGroundFragment extends Fragment {
    FragmentBuyBackGroundBinding bindingBg;
    Context mcontext;

    public static BuyBackGroundFragment newInstance() {
        return new BuyBackGroundFragment();
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        mcontext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        bindingBg = FragmentBuyBackGroundBinding.inflate(inflater, container, false);
        View view = bindingBg.getRoot();

        bindingBg.backg.setText("배경구매");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bindingBg = null;
    }
}