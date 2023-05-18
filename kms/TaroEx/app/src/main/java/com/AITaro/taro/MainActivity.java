package com.AITaro.taro;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.util.Log;
import android.widget.Adapter;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.AITaro.taro.Adapter.CardListAdapter;
import com.AITaro.taro.Interface.CardNumber;
import com.AITaro.taro.Items.RecyclerViewItem;
import com.AITaro.taro.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding b_main;
    private CardListAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b_main = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b_main.getRoot());

        init();
        getData();

    }

    void init() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        b_main.cardRecyclerView.setLayoutManager(linearLayoutManager);

        Adapter = new CardListAdapter();
        b_main.cardRecyclerView.setAdapter(Adapter);

    }

    private void getData() {
        Intent intent = getIntent();
        RecyclerViewItem data = new RecyclerViewItem();



     //   List<Integer> str = (ArrayList<Integer>) getIntent().getSerializableExtra("s");


            ArrayList arrayList = intent.getExtras().getStringArrayList("s");

            try {
                for (int i = 0; i < arrayList.size(); i++) {

                    data.setTaroImage((Integer) arrayList.get(i));
                    Adapter.addItem(data);

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        List<Integer> imageList = Arrays.asList(
                R.drawable.main2,
                R.drawable.main);

          /*  for (int i = 0; i <imageList.size(); i++) {
                data.setTaroImage(imageList.get(i));
                Adapter.addItem(data);
            }*/

    }
}