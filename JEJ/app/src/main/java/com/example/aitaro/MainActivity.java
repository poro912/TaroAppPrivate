package com.example.aitaro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.aitaro.databinding.ActivityMainBinding;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import com.example.aitaro.CardAdapter;
import com.example.aitaro.CardItem;


    public class MainActivity extends AppCompatActivity {
        private RecyclerView recyclerView;
    private CardAdapter cardAdapter;
    private List<CardItem> cardItems;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        cardItems = generateCardItems();
        cardAdapter = new CardAdapter(cardItems);
        recyclerView.setAdapter(cardAdapter);
    }

    private List<CardItem> generateCardItems() {
        List<CardItem> cardItems = new ArrayList<>();
        random = new Random();

        // 카드 이미지 리소스 아이디 배열
        int[] cardImageResources = {
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back,
                R.drawable.back
        };

        // 카드 이미지 리소스 아이디를 랜덤하게 선택하여 CardItem 객체 생성 후 리스트에 추가
        for (int i = 0; i < 78; i++) {
            int randomIndex = random.nextInt(cardImageResources.length);
            int randomImageResource = cardImageResources[randomIndex];
            cardItems.add(new CardItem(randomImageResource));
        }

        // 리스트 순서 랜덤하게 섞기
        Collections.shuffle(cardItems);

        return cardItems;
    }
}
