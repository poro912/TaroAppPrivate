package com.example.aitaro;

import android.content.Intent;
import android.widget.AdapterView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.aitaro.databinding.ActivityMainBinding;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.io.Serializable;
import java.util.*;

import com.example.aitaro.CardAdapter;
import com.example.aitaro.CardItem;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private List<CardItem> cardItems;
    private Random random;
    private int cardcnt;
    private Set<Integer> selectedCardPositions = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        Intent intent = getIntent();
        cardcnt = intent.getIntExtra("cardcnt", 0);

        cardItems = generateCardItems(cardcnt);

        cardAdapter = new CardAdapter(cardItems);
        cardAdapter.setOnItemClickListener(this);  // 클릭 리스너 설정
        recyclerView.setAdapter(cardAdapter);
    }

    private List<CardItem> generateCardItems(int cardcnt) {
        List<CardItem> cardItems = new ArrayList<>();
        random = new Random();
        ArrayList<Integer> cardImage = new ArrayList<>();

        for (int i = 0; i < cardcnt; i++) {
            cardImage.add(R.drawable.back);
        }

        // 카드 이미지 리소스 아이디를 랜덤하게 선택하여 CardItem 객체 생성 후 리스트에 추가
        for (int i = 0; i < cardcnt; i++) {
            int randomIndex = random.nextInt(cardImage.size());
            int randomImageResource = cardImage.get(randomIndex);
            cardItems.add(new CardItem(randomImageResource));
        }

        return cardItems;
    }

    @Override
    public void onItemClick(int position) {
        selectedCardPositions.add(position);
        if (selectedCardPositions.size() == cardcnt) {
            List<Integer> randomValues = generateRandomCardValues(cardcnt);  // 1부터 78까지의 랜덤한 값들 생성

            // 인텐트를 생성하여 값을 전달
            Intent intent = new Intent(this, EndActivity.class);
            intent.putIntegerArrayListExtra("cardValues", new ArrayList<>(randomValues));
            startActivity(intent);
        }
    }

    private List<Integer> generateRandomCardValues(int count) {
        List<Integer> randomValues = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < count; i++) {
            int randomValue = random.nextInt(78) + 1; // 1부터 78까지의 랜덤한 값 생성
            randomValues.add(randomValue);
        }
        return randomValues;
    }

}