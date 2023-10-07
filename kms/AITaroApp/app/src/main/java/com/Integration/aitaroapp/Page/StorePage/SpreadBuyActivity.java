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
import com.Integration.aitaroapp.databinding.ActivitySpreadBuyBinding;

import java.util.ArrayList;

public class SpreadBuyActivity extends AppCompatActivity {
    private ActivitySpreadBuyBinding binding_spread;
    private DividerItemDecoration dividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding_spread = ActivitySpreadBuyBinding.inflate(getLayoutInflater());
        setContentView(binding_spread.getRoot());

        init();

    }

    private void init() {
        recyclerviewAdapter();
    }

    private void recyclerviewAdapter() {
        dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);

        ArrayList<StoreBuyItemClass> image_datas = new ArrayList<>();
        image_datas.add(new StoreBuyItemClass(R.drawable.back_taro_card));
        image_datas.add(new StoreBuyItemClass(R.drawable.back));
        image_datas.add(new StoreBuyItemClass(R.drawable.main2));
        image_datas.add(new StoreBuyItemClass(R.drawable.add_icon));
        StoreItemRecyclerViewAdapter storeItemRecyclerViewAdapter = new StoreItemRecyclerViewAdapter(image_datas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        binding_spread.buySpreadRecyclerview.addItemDecoration(dividerItemDecoration);      //리사이클러뷰 선긋기
        binding_spread.buySpreadRecyclerview.setLayoutManager(linearLayoutManager);        //리니어레이아웃 버티컬
        binding_spread.buySpreadRecyclerview.setAdapter(storeItemRecyclerViewAdapter);

        storeItemRecyclerViewAdapter.notifyDataSetChanged();
    }
}