package com.Integration.aitaroapp.Page.StorePage;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Adapter.StoreItemRecyclerViewAdapter;
import com.Integration.aitaroapp.Page.Item.StoreBuyItemClass;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityBackgroundBuyBinding;

import java.util.ArrayList;

public class BackgroundBuyActivity extends AppCompatActivity {
    private ActivityBackgroundBuyBinding binding_bg;
    private DividerItemDecoration dividerItemDecoration;
    private Intent get_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding_bg = ActivityBackgroundBuyBinding.inflate(getLayoutInflater());
        setContentView(binding_bg.getRoot());

        init();
    }

    private void init(){
        recyclerviewAdapter();
    }

    private void recyclerviewAdapter(){
        dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);

        ArrayList<StoreBuyItemClass> image_datas = new ArrayList<>();
        image_datas.add(new StoreBuyItemClass(R.drawable.taro_0));
        image_datas.add(new StoreBuyItemClass(R.drawable.taro_1));
        image_datas.add(new StoreBuyItemClass(R.drawable.taro_2));
        image_datas.add(new StoreBuyItemClass(R.drawable.taro_3));
        StoreItemRecyclerViewAdapter storeItemRecyclerViewAdapter = new StoreItemRecyclerViewAdapter(image_datas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        binding_bg.buyBackgroundRecyclerview.addItemDecoration(dividerItemDecoration);      //리사이클러뷰 선긋기
        binding_bg.buyBackgroundRecyclerview.setLayoutManager(linearLayoutManager);        //리니어레이아웃 버티컬
        binding_bg.buyBackgroundRecyclerview.setAdapter(storeItemRecyclerViewAdapter);

        storeItemRecyclerViewAdapter.notifyDataSetChanged();
    }
}