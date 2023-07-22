package com.Integration.aitaroapp.Page.Fragmant;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.FragmentSetThreeCardBinding;
import org.jetbrains.annotations.NotNull;


public class SetThreeCardFragment extends Fragment {
    private FragmentSetThreeCardBinding _binding_fragment_set_three_card;
    private Context mc;

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
        _binding_fragment_set_three_card = FragmentSetThreeCardBinding.inflate(inflater, container, false);
        View v = _binding_fragment_set_three_card.getRoot();


        return v;
    }
}