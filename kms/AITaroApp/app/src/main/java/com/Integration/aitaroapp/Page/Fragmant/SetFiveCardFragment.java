package com.Integration.aitaroapp.Page.Fragmant;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.FragmentSetFiveCardBinding;
import org.jetbrains.annotations.NotNull;

public class SetFiveCardFragment extends Fragment {
    private Context mc;
    private FragmentSetFiveCardBinding _binding_fragment_set_five_card;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.mc = context;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _binding_fragment_set_five_card = FragmentSetFiveCardBinding.inflate(inflater, container, false);
        View v = _binding_fragment_set_five_card.getRoot();


        return v;
    }
}