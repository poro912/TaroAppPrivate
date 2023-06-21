package com.StoreSettingPackage;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.AITaro.taro.R;
import com.AITaro.taro.databinding.FragmentBuycardBinding;
import org.jetbrains.annotations.NotNull;

public class buycard_Fragment extends Fragment {

    private FragmentBuycardBinding bindingBuyCard;
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
        bindingBuyCard = FragmentBuycardBinding.inflate(inflater, container, false);
        View view = bindingBuyCard.getRoot();

        bindingBuyCard.buyCardPage.setText("카드구매 페이지");
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        bindingBuyCard = null;
    }
}