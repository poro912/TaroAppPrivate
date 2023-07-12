package com.Integration.aitaroapp.Page;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Adapter.CardDrawAdapter;
import com.Integration.aitaroapp.Page.Custom.CustomBtn;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding _binding_mainPage;
    CardDrawAdapter cardDrawAdapter;
    private ArrayList<CardItem> draw_card_item = new ArrayList<>();
    Intent getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_mainPage = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding_mainPage.getRoot());

        getData = getIntent();

        init();

    }

    private void init() {
        drawCardItem();
        getDrawCard();
        CustomWidget();
    }



    private void drawCardItem() {
        int span_count = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(this, span_count, RecyclerView.HORIZONTAL, false);
        cardDrawAdapter = new CardDrawAdapter(this, draw_card_item);
        _binding_mainPage.taroCardSelectedRecyclerView.setLayoutManager(layoutManager);
        _binding_mainPage.taroCardSelectedRecyclerView.setAdapter(cardDrawAdapter);
    }

    private void getDrawCard(){
        CardItem draw_card = new CardItem();

        for (int i = 0; i < 86; i ++){
            draw_card.setCard_item(R.drawable.backoftarocard);
            cardDrawAdapter.addItem(draw_card);
        }
    }

    private void CustomWidget(){
        CustomBtn customBtn = new CustomBtn(this, _binding_mainPage.buttonView);
        customBtn.storeSettingBtn();
    }
}