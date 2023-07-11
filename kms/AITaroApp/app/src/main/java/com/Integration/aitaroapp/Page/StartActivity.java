package com.Integration.aitaroapp.Page;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.Integration.aitaroapp.Page.Adapter.GameSelectedRecyclerViewAdapter;
import com.Integration.aitaroapp.Page.Item.MainBtnSelected;
import com.Integration.aitaroapp.databinding.ActivityStartBinding;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity  {
    private ActivityStartBinding _binding_startPage;
    private int card_cut;
    private ArrayList<MainBtnSelected> btn_item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_startPage = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(_binding_startPage.getRoot());

        init();


    }

    private void init() {
        mainWindowTouch();
        recyclerViewItem();
    }

    private void mainWindowTouch() {
        _binding_startPage.startImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _binding_startPage.startImage.setVisibility(View.GONE);
                _binding_startPage.cardSelectRecyclerView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void recyclerViewItem(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        _binding_startPage.cardSelectRecyclerView.setLayoutManager(linearLayoutManager);
        GameSelectedRecyclerViewAdapter mainRecyclerViewAdapter = new GameSelectedRecyclerViewAdapter(btn_item);
        _binding_startPage.cardSelectRecyclerView.setAdapter(mainRecyclerViewAdapter);

        btn_item.add(new MainBtnSelected("threeCard"));
        btn_item.add(new MainBtnSelected("fiveCard"));
        btn_item.add(new MainBtnSelected("eightCard"));

    }
}