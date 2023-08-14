package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Adapter.CardDrawAdapter;
import com.Integration.aitaroapp.Page.Dialog.BaseActivity;
import com.Integration.aitaroapp.Page.Dialog.MyDialog;
import com.Integration.aitaroapp.Page.Interface.CardSelectionListener;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends BaseActivity implements CardSelectionListener, ExitDialogListener.Finished {
    private ActivityMainBinding _binding_mainPage;
    private CardDrawAdapter cardDrawAdapter;
    private ArrayList<CardItem> draw_card_item = new ArrayList<>();
    private ArrayList<Integer> selectedCard = new ArrayList<>();
    private Random random_card;
    private MyDialog myDialog;
    static long back_pressed_time = 0;
    Intent get_data;
    Intent move_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_mainPage = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding_mainPage.getRoot());

        //인텐트
        get_data = getIntent();
        //어댑터 객체 생성
        cardDrawAdapter = new CardDrawAdapter(this, draw_card_item);

        random_card = new Random();

        init();
    }

    private void init() {
        drawCardItem();
        getDrawCard();
        deckShuffle();
        intentViewPage();
        resultBtn();
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
            draw_card.setSelected_num(random_card.nextInt(86) + 1);
            cardDrawAdapter.addItem(draw_card);
        }
    }

    private void deckShuffle() {
        _binding_mainPage.suffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "셔플", Toast.LENGTH_SHORT).show();
                shuffleCards();
                Log.d("loglog", "셔플" + cardDrawAdapter.getItemCount());
            }
        });
    }

    private void shuffleCards() {
        cardDrawAdapter.shuffleCards();
    }


    private void intentViewPage() {
        if (get_data.hasExtra("three_card")) {
            _binding_mainPage.threeCardInclude.threeCardLayout.setVisibility(View.VISIBLE);
        }
        if (get_data.hasExtra("five_card")) {
            _binding_mainPage.fiveCardInclude.fiveCardLayout.setVisibility(View.VISIBLE);
        }
        if (get_data.hasExtra("eight_card")) {
            _binding_mainPage.eightCardInclude.eightCardLayout.setVisibility(View.VISIBLE);
        }
    }

    private void resultBtn() {
        move_result = new Intent(this, ResultActivity.class);
        _binding_mainPage.resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedCard.size() == 3) {
                    Log.d("loglog", "main_Three" + String.valueOf(selectedCard));
                    move_result.putExtra("card_result3", selectedCard);
                    startActivity(move_result);
                    finish();
                }
                if (selectedCard.size() == 5) {
                    Log.d("loglog", "main_Five" + String.valueOf(selectedCard));
                    move_result.putExtra("card_result5", selectedCard);
                    startActivity(move_result);
                    finish();
                }
                if (selectedCard.size() == 8) {
                    Log.d("loglog", "main_Eight" + String.valueOf(selectedCard));
                    move_result.putExtra("card_result8", selectedCard);
                    startActivity(move_result);
                    finish();
                }

                Toast.makeText(MainActivity.this, selectedCard.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCardSelected(CardItem cardItem, ArrayList<Integer> cardDrawn) {
        this.selectedCard = cardDrawn;
        if (get_data.hasExtra("three_card")) {
            Log.d("loglog", "selected Cards: " + selectedCard.toString());
            if (selectedCard.size() == 3) {     //뽑은 카드ArrayList의 사이즈가 3이면
                _binding_mainPage.resultBtn.setVisibility(View.VISIBLE);//결과 버튼을 보이기
                Log.d("loglog", "exit" + selectedCard.size());
                _binding_mainPage.taroCardSelectedRecyclerView.setVisibility(View.GONE);

                /*  initCardList();     //카드 초기화, 다시뽑기*/

            }

            //selectedCard ArrayList에 값이 들어오면 사이즈별 마다 카드를 채워넣도록 변경
            if (selectedCard.size() == 1) {
                _binding_mainPage.threeCardInclude.threeCardPos1Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 2) {
                _binding_mainPage.threeCardInclude.threeCardPos2Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 3) {
                _binding_mainPage.threeCardInclude.threeCardPos3Card.setImageResource(R.drawable.backoftarocard);
            }
        }

        if (get_data.hasExtra("five_card")) {
            Log.d("loglog", "selected Cards: " + selectedCard.toString());
            if (selectedCard.size() == 5) {     //뽑은 카드ArrayList의 사이즈가 5이면
                _binding_mainPage.resultBtn.setVisibility(View.VISIBLE);        //결과 버튼을 보이기
                Log.d("loglog", "exit" + selectedCard.size());

                _binding_mainPage.taroCardSelectedRecyclerView.setVisibility(View.GONE);
            }

            if (selectedCard.size() == 1) {
                _binding_mainPage.fiveCardInclude.fiveCardPos1Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 2) {
                _binding_mainPage.fiveCardInclude.fiveCardPos2Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 3) {
                _binding_mainPage.fiveCardInclude.fiveCardPos3Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 4) {
                _binding_mainPage.fiveCardInclude.fiveCardPos4Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 5) {
                _binding_mainPage.fiveCardInclude.fiveCardPos5Card.setImageResource(R.drawable.backoftarocard);
            }
        }
        if (get_data.hasExtra("eight_card")) {
            Log.d("loglog", "selected Cards: " + selectedCard.toString());
            if (selectedCard.size() == 8) {
                _binding_mainPage.resultBtn.setVisibility(View.VISIBLE);
                Log.d("loglog", "exit" + selectedCard.size());

                _binding_mainPage.taroCardSelectedRecyclerView.setVisibility(View.GONE);
            }

            if (selectedCard.size() == 1) {
                _binding_mainPage.eightCardInclude.eightCardPos1Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 2) {
                _binding_mainPage.eightCardInclude.eightCardPos2Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 3) {
                _binding_mainPage.eightCardInclude.eightCardPos3Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 4) {
                _binding_mainPage.eightCardInclude.eightCardPos4Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 5) {
                _binding_mainPage.eightCardInclude.eightCardPos5Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 6) {
                _binding_mainPage.eightCardInclude.eightCardPos6Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 7) {
                _binding_mainPage.eightCardInclude.eightCardPos7Card.setImageResource(R.drawable.backoftarocard);
            } else if (selectedCard.size() == 8) {
                _binding_mainPage.eightCardInclude.eightCardPos8Card.setImageResource(R.drawable.backoftarocard);
            }
        }
    }

    @Override
    public void onBackPressed() {
        myDialog = new MyDialog(this);
        myDialog.show();

         myDialog.dialogBtn("back_pressed");
    }
    @Override
    public void onFinishActivity() {
        super.onFinishActivity();
    }
}
