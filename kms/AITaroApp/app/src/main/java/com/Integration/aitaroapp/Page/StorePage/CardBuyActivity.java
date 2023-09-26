package com.Integration.aitaroapp.Page.StorePage;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Adapter.StoreItemRecyclerViewAdapter;
import com.Integration.aitaroapp.Page.Item.StoreBuyItemClass;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityCardBuyBinding;

import java.util.ArrayList;

public class CardBuyActivity extends AppCompatActivity {
    private ActivityCardBuyBinding binding_card;
    private DividerItemDecoration dividerItemDecoration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding_card = ActivityCardBuyBinding.inflate(getLayoutInflater());
        setContentView(binding_card.getRoot());

        init();
    }

    private void init(){
        recyclerviewAdapter();
    }

    private void recyclerviewAdapter(){
        dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        ArrayList<StoreBuyItemClass> image_datas = new ArrayList<>();
        image_datas.add(new StoreBuyItemClass(R.drawable.taro_3));
        image_datas.add(new StoreBuyItemClass(R.drawable.taro_33));
        image_datas.add(new StoreBuyItemClass(R.drawable.taro_0));
        image_datas.add(new StoreBuyItemClass(R.drawable.taro_6));
        StoreItemRecyclerViewAdapter storeItemRecyclerViewAdapter = new StoreItemRecyclerViewAdapter(image_datas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        binding_card.buyCardRecyclerview.addItemDecoration(dividerItemDecoration);      //리사이클러뷰 선긋기
        binding_card.buyCardRecyclerview.setLayoutManager(linearLayoutManager);        //리니어레이아웃 버티컬
        binding_card.buyCardRecyclerview.setAdapter(storeItemRecyclerViewAdapter);

        storeItemRecyclerViewAdapter.notifyDataSetChanged();
    }
}