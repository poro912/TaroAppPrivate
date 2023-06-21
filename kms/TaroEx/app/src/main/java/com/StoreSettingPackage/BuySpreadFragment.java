package com.StoreSettingPackage;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.AITaro.taro.R;
import com.AITaro.taro.databinding.FragmentBuySpreadBinding;
import org.jetbrains.annotations.NotNull;


public class BuySpreadFragment extends Fragment {

    FragmentBuySpreadBinding bindingSpread;
    Context mcontext;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindingSpread = FragmentBuySpreadBinding.inflate(inflater, container, false);
        View view = bindingSpread.getRoot();

        bindingSpread.spread.setText("스프레드 구매");

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bindingSpread = null;

    }
}