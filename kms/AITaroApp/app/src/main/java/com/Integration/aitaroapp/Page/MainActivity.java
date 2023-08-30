package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Adapter.CardDrawAdapter;
import com.Integration.aitaroapp.Page.Dialog.MyDialog;
import com.Integration.aitaroapp.Page.Interface.CardSelectionListener;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends BaseActivity implements CardSelectionListener, ExitDialogListener.Finished {
    private ActivityMainBinding _binding_mainPage;
    private CardDrawAdapter cardDrawAdapter;
    private ArrayList<CardItem> draw_card_item = new ArrayList<>();     //리사이클러뷰 타로카드 뒷면 장수
    static ArrayList<Integer> selectedCard = new ArrayList<>();         //뽑은 카드 계수
    private Random random_card;
    private MyDialog myDialog;
    static final private int CARD_NUMBER = 78;      //타로카드 장수 고정
    Intent get_data;            //인텐트로 게임 별 타로카드 장수 가져오기
    Intent move_result;       //뽑은 카드값 넘겨주기
    private int viewId;        //getResources().getIdentifier()
    private ImageView image_item;       //카드 뒷면 이미지 변경

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_mainPage = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(_binding_mainPage.getRoot());

        init();
    }

    private void init() {
        //인텐트
        get_data = getIntent();
        //어댑터 객체 생성
        cardDrawAdapter = new CardDrawAdapter(this, draw_card_item);
        random_card = new Random();

        drawCardItem();     //타로카드 장수 리사이클러뷰 연결
        getDrawCard();      //타로카드 관련 이미지, 랜덤 값 배열생성
        deckShuffle();       //카드 셔플
        intentViewPage();   //인텐트로 게임 종류 가져옴
        resultBtn();
        resetBtn();

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
        for (int i = 0; i < CARD_NUMBER; i++) {
            CardItem draw_card = new CardItem();
            draw_card.setCard_item(R.drawable.back_taro_card);

            String imageName = "taro_" + i;
            int viewId = getResources().getIdentifier(imageName, "drawable", getPackageName());
            draw_card.setCard_value(viewId);
            /*Log.d("loglog", "카드 이미지 이름 및 숫자: " + imageName + ", 리소스 ID: " + viewId);*/
            Log.d("loglog", "카드" + draw_card);

            // 카드값 int 랜덤 배정
            draw_card.setSelected_num(random_card.nextInt(77) + 1);
            cardDrawAdapter.addItem(draw_card);
        }
    }

    private void deckShuffle() {
        _binding_mainPage.suffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffleCards();
            }
        });
    }

    private void shuffleCards() {
        ArrayList<CardItem> shuffledItems = new ArrayList<>(draw_card_item);
        Collections.shuffle(shuffledItems);

        for (int i = 0; i < draw_card_item.size(); i++) {
            draw_card_item.set(i, shuffledItems.get(i));
            Log.d("loglog", "셔플" + draw_card_item.get(i));

        }

        cardDrawAdapter.notifyDataSetChanged();

        Toast.makeText(MainActivity.this, "셔플", Toast.LENGTH_SHORT).show();
        Log.d("loglog", "셔플 후 카드 개수: " + cardDrawAdapter.getItemCount());
        Log.d("loglog", "셔플 후 카드 아이템: " + draw_card_item.toString());

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
                int result_selected_card_size = selectedCard.size();
                Log.d("loglog", "뽑은 카드 갯수 : " + String.valueOf(result_selected_card_size));
                move_result.putExtra("card_result" + result_selected_card_size, selectedCard);
                startActivity(move_result);
                finish();

                Toast.makeText(MainActivity.this, selectedCard.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void resetBtn() {
        int totalCardCount = cardDrawAdapter.getItemCount();
        Log.d("loglog", "기존 남은 카드 수" + String.valueOf(draw_card_item.size()));
        Log.d("loglog", "기존 남은 카드 수 배열" + String.valueOf(draw_card_item.size()));
        _binding_mainPage.resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("loglog", "기존 선택된 카드 수 배열" + String.valueOf(selectedCard.size()));
                Log.d("loglog", "기존 남은 카드 수 배열" + String.valueOf(draw_card_item.size()));

                if (get_data.hasExtra("three_card")) {
                    for (int i = 0; i < selectedCard.size(); i++) {
                        viewId = getResources().getIdentifier("three_card_pos" + i, "id", getPackageName());
                        image_item = _binding_mainPage.threeCardInclude.threeCardLayout.findViewById(viewId);

                        if (image_item != null) {
                            image_item.setImageResource(R.drawable.card_result_img);
                        }
                    }
                }

                if (get_data.hasExtra("five_card")) {
                    for (int i = 0; i < selectedCard.size(); i++) {
                        viewId = getResources().getIdentifier("five_card_pos" + i, "id", getPackageName());
                        image_item = _binding_mainPage.fiveCardInclude.fiveCardLayout.findViewById(viewId);

                        if (image_item != null) {
                            image_item.setImageResource(R.drawable.card_result_img);
                        }
                    }
                }

                if (get_data.hasExtra("eight_card")) {
                    for (int i = 0; i < selectedCard.size(); i++) {
                        viewId = getResources().getIdentifier("eight_card_pos" + i, "id", getPackageName());
                        image_item = _binding_mainPage.eightCardInclude.eightCardLayout.findViewById(viewId);

                        if (image_item != null) {
                            image_item.setImageResource(R.drawable.card_result_img);
                        }
                    }
                }

                draw_card_item.get(selectedCard.size());
                selectedCard.clear();
                cardDrawAdapter.restoreRemovedCards();
                cardDrawAdapter.notifyDataSetChanged();

                _binding_mainPage.taroCardSelectedRecyclerView.setVisibility(View.VISIBLE);
                Log.d("loglog", "리셋 버튼 후 남은 카드 수" + String.valueOf(draw_card_item.size()));
                Log.d("loglog", "리셋 선택된 카드 수" + String.valueOf(selectedCard.size()));
                Log.d("loglog", "총 카드 수 " + totalCardCount);

                _binding_mainPage.resultBtn.setVisibility(View.INVISIBLE);
                _binding_mainPage.resetBtn.setVisibility(View.INVISIBLE);
                _binding_mainPage.suffleBtn.setVisibility(View.VISIBLE);
            }
        });
    }

    private void visibilityItem() {
        //결과카드를 다 뽑았을 때 보이기/숨기기
        //카드가 모두 뽑힐 경우
        _binding_mainPage.resultBtn.setVisibility(View.VISIBLE);    //결과 버튼을 보이기
        _binding_mainPage.taroCardSelectedRecyclerView.setVisibility(View.GONE);    //카드들 없애기
        _binding_mainPage.resetBtn.setVisibility(View.VISIBLE);     //리셋버튼 보이기
        _binding_mainPage.suffleBtn.setVisibility(View.INVISIBLE);  //셔플버튼 없애기
    }

    private void cardExpectedOver(int expectedCardCount){
        if (expectedCardCount < selectedCard.size()){
            selectedCard.remove(selectedCard.size() - 1);
        }
    }

    @Override
    public void onCardSelected(CardItem cardItem, ArrayList<Integer> cardDrawn) {
        this.selectedCard = cardDrawn;
        int result_selected_card_size = selectedCard.size();

        if (get_data.hasExtra("three_card")) {
            Log.d("loglog", "selected Cards: " + selectedCard.toString());

            if (result_selected_card_size == 3) {     //뽑은 카드ArrayList의 사이즈가 3이면
               visibilityItem();
            }

            cardExpectedOver(3);

            for (int i = 0; i < result_selected_card_size; i++) {
                viewId = getResources().getIdentifier("three_card_pos" + i, "id", getPackageName());
                image_item = _binding_mainPage.threeCardInclude.threeCardLayout.findViewById(viewId);

                if (image_item != null) {
                    image_item.setImageResource(R.drawable.back_taro_card);
                }
            }
        }

        if (get_data.hasExtra("five_card")) {
            Log.d("loglog", "selected Cards: " + selectedCard.toString());

            if (result_selected_card_size == 5) {     //뽑은 카드ArrayList의 사이즈가 5이면
                visibilityItem();
            }

            cardExpectedOver(5);

            for (int i = 0; i < result_selected_card_size; i++) {
                viewId = getResources().getIdentifier("five_card_pos" + i, "id", getPackageName());
                image_item = _binding_mainPage.fiveCardInclude.fiveCardLayout.findViewById(viewId);

                if (image_item != null) {
                    image_item.setImageResource(R.drawable.back_taro_card);
                }
            }


        }

        if (get_data.hasExtra("eight_card")) {
            Log.d("loglog", "selected Cards: " + selectedCard.toString());
            if (result_selected_card_size == 8) {
                visibilityItem();
            }

            cardExpectedOver(8);

            for (int i = 0; i < result_selected_card_size; i++) {
                viewId = getResources().getIdentifier("eight_card_pos" + i, "id", getPackageName());
                image_item = _binding_mainPage.eightCardInclude.eightCardLayout.findViewById(viewId);

                if (image_item != null) {
                    image_item.setImageResource(R.drawable.back_taro_card);
                }
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
