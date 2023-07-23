package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
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
import java.util.List;
import java.util.Random;

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
        deckShuffle();
    }


    private void drawCardItem() {
        draw_card_item.clear();
        int span_count = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(this, span_count, RecyclerView.HORIZONTAL, false);
        cardDrawAdapter = new CardDrawAdapter(this, draw_card_item);
        _binding_mainPage.taroCardSelectedRecyclerView.setLayoutManager(layoutManager);
        _binding_mainPage.taroCardSelectedRecyclerView.setAdapter(cardDrawAdapter);
    }

    private void getDrawCard() {
        Random r = new Random();
        for (int i = 0; i < 86; i++) {
            CardItem draw_card = new CardItem();
            draw_card.setCard_item(R.drawable.backoftarocard);
            draw_card.setSelected_num((r.nextInt() + i));
            cardDrawAdapter.addItem(draw_card);
            Log.d("MainActivity", "Card Number: " + i);
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

    private void deckShuffle(){
        _binding_mainPage.suffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "셔플", Toast.LENGTH_SHORT).show();
                shuffleCards();
            }
        });
    }

    private void shuffleCards() {
        // 카드 아이템 리스트를 섞습니다.
        Collections.shuffle(draw_card_item);
        // RecyclerView를 업데이트하여 섞인 카드를 표시합니다.
        cardDrawAdapter.notifyDataSetChanged();
    }

}