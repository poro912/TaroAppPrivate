package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Adapter.CardDrawAdapter;
import com.Integration.aitaroapp.Page.Interface.CardSelectionListener;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements CardSelectionListener {
    private ActivityMainBinding _binding_mainPage;
    CardDrawAdapter cardDrawAdapter;
    private ArrayList<CardItem> draw_card_item = new ArrayList<>();
    private ArrayList<Integer> selectedCard = new ArrayList<>();
    private Random r;

    Intent getData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_mainPage = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding_mainPage.getRoot());

        //인텐트
        getData = getIntent();
        //어댑터 객체 생성
        cardDrawAdapter = new CardDrawAdapter(this, draw_card_item);

        r = new Random();

        init();
    }

    private void init() {
        drawCardItem();
        getDrawCard();
        deckShuffle();
        intentViewPage();
    }


    private void drawCardItem() {
        draw_card_item.clear();
        int span_count = 2;
        GridLayoutManager layoutManager = new GridLayoutManager(this, span_count, RecyclerView.HORIZONTAL, false);
        _binding_mainPage.taroCardSelectedRecyclerView.setLayoutManager(layoutManager);
        _binding_mainPage.taroCardSelectedRecyclerView.setAdapter(cardDrawAdapter);

        // 인터페이스를 생성하여 매인 액티비티에서 클릭 이벤트 적용
        cardDrawAdapter.setCardSelectionListener(this);
    }

    private void getDrawCard() {
        for (int i = 0; i < 86; i++) {
            CardItem draw_card = new CardItem();
            draw_card.setCard_item(R.drawable.backoftarocard);
            //카드값 int 랜덤 배정
            draw_card.setSelected_num(r.nextInt(86) + 1);
            cardDrawAdapter.addItem(draw_card);
        }
    }

    private void deckShuffle() {
        _binding_mainPage.suffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "셔플", Toast.LENGTH_SHORT).show();
                shuffleCards();
            }
        });
    }

    private void shuffleCards() {
        cardDrawAdapter.shuffleCards();
    }


    private void intentViewPage() {
        if (getData.hasExtra("three_card")) {
            _binding_mainPage.threeCardInclude.threeCardLayout.setVisibility(View.VISIBLE);
        }
         if (getData.hasExtra("five_card")) {
            _binding_mainPage.fiveCardInclude.fiveCardLayout.setVisibility(View.VISIBLE);
        }
         if (getData.hasExtra("eight_card")) {
            _binding_mainPage.eightCardInclude.eightCardLayout.setVisibility(View.VISIBLE);
        }
    }
    @Override
    public void onCardSelected(CardItem cardItem, ArrayList<Integer> cardDrawn) {
        if (getData.hasExtra("three_card")) {
            this.selectedCard = cardDrawn;

            Log.d("loglog", "selected Cards: " + selectedCard.toString());
            if (selectedCard.size() == 3){
                _binding_mainPage.resultBtn.setVisibility(View.VISIBLE);
                Log.d("loglog", "exit" + selectedCard.size());

                _binding_mainPage.taroCardSelectedRecyclerView.setVisibility(View.GONE);
            }


        }

        if (getData.hasExtra("five_card")) {



        }
        if (getData.hasExtra("eight_card")) {



        }
    }
}