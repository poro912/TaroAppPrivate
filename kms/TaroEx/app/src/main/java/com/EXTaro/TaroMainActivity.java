package com.EXTaro;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import com.AITaro.taro.R;
import com.AITaro.taro.databinding.ActivityTaroMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TaroMainActivity extends AppCompatActivity {

    private List<CardItem> cardItems;
    private Random random;
    private CardAdapter cardAdapter;
    private ActivityTaroMainBinding TaroBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TaroBinding = ActivityTaroMainBinding.inflate(getLayoutInflater());
        setContentView(TaroBinding.getRoot());

        TaroBinding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        cardItems = generateCardItems();
        cardAdapter = new CardAdapter(cardItems);
        TaroBinding.recyclerView.setAdapter(cardAdapter);
    }//endOfCalss


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
