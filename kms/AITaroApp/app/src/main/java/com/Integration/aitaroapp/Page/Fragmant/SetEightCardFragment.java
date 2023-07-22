package com.Integration.aitaroapp.Page.Fragmant;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.FragmentSetEightCardBinding;
import org.jetbrains.annotations.NotNull;


public class SetEightCardFragment extends Fragment {
    FragmentSetEightCardBinding _binding_fragment_set_eight_card;
    Context mcontext;

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        this.mcontext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        _binding_fragment_set_eight_card = FragmentSetEightCardBinding.inflate(inflater, container, false);
        View view = _binding_fragment_set_eight_card.getRoot();


        return view;
    }
}