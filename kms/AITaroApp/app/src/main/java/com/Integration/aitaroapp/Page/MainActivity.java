package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Adapter.CardDrawAdapter;
import com.Integration.aitaroapp.Page.Fragmant.SetEightCardFragment;
import com.Integration.aitaroapp.Page.Fragmant.SetFiveCardFragment;
import com.Integration.aitaroapp.Page.Fragmant.SetThreeCardFragment;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding _binding_mainPage;
    CardDrawAdapter cardDrawAdapter;
    private ArrayList<CardItem> draw_card_item = new ArrayList<>();
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private SetThreeCardFragment setThreeCardFragment;
    private SetFiveCardFragment setFiveCardFragment;
    private SetEightCardFragment setEightCardFragment;
    Intent getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_mainPage = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding_mainPage.getRoot());

        //인텐트
        getData = getIntent();
        //프레그먼트 트랜젝션
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        init();
    }

    private void init() {
        drawCardItem();
        getDrawCard();
        fiveCard();
    }


    private void drawCardItem() {
        int span_count = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(this, span_count, RecyclerView.HORIZONTAL, false);
        cardDrawAdapter = new CardDrawAdapter(this, draw_card_item);
        _binding_mainPage.taroCardSelectedRecyclerView.setLayoutManager(layoutManager);
        _binding_mainPage.taroCardSelectedRecyclerView.setAdapter(cardDrawAdapter);
    }

    private void getDrawCard() {
        CardItem draw_card = new CardItem();

        for (int i = 0; i < 86; i++) {
            draw_card.setCard_item(R.drawable.backoftarocard);
            cardDrawAdapter.addItem(draw_card);
        }
    }

    private void fiveCard() {
        setThreeCardFragment = new SetThreeCardFragment();
        setFiveCardFragment = new SetFiveCardFragment();
        setEightCardFragment = new SetEightCardFragment();

        if (getData.hasExtra("three_card")){
            fragmentTransaction.replace(R.id.card_result_layout, setThreeCardFragment).commit();
        }
        if (getData.hasExtra("five_card")){
            fragmentTransaction.replace(R.id.card_result_layout, setFiveCardFragment).commit();
        }
        if (getData.hasExtra("eight_card")){
            fragmentTransaction.replace(R.id.card_result_layout, setEightCardFragment).commit();
        }

    }

}