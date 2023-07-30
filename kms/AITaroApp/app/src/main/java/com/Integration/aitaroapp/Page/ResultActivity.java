package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.Integration.aitaroapp.Page.Adapter.CardDrawAdapter;
import com.Integration.aitaroapp.Page.Interface.CardSelectionListener;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityResultBinding;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    private CardDrawAdapter cardDrawAdapter;
    private ActivityResultBinding _binding_result_page;
    private Intent get_data;
    private ArrayList<Integer> result_card = new ArrayList<>();     //결과 카드들을 담을 ArrayList
    private ArrayList<CardItem> card_items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_result_page = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(_binding_result_page.getRoot());

        get_data = getIntent();

        init();
    }

    private void init() {
        setAdapter();
       /* cardValue(result_card);*/
        handleReceivedArrayList();
    }

    private void setAdapter() {
       /* cardDrawAdapter = new CardDrawAdapter(this, card_items);
        cardDrawAdapter.setCardSelectionListener((CardSelectionListener) this);*/
    }

    private void handleReceivedArrayList() {
        result_card = getReceivedArrayList();
        if (result_card != null) {
            if (get_data != null && get_data.hasExtra("card_result3")) {

                _binding_result_page.resultThreeCardInclude.resultThreeCardPage.setVisibility(View.VISIBLE);
                Log.d("loglog", "ThreeCardPage" + String.valueOf(result_card));
                Log.d("loglog", "get_data = " +result_card);
                Log.d("loglog", "get_data3 = " + get_data.getSerializableExtra("card_result3"));
            }
            // receivedArrayList에 전달받은 ArrayList가 들어있습니다.
            // 원하는 작업을 수행하시면 됩니다.
        }
    }

    private ArrayList<Integer> getReceivedArrayList() {
        if (get_data != null && get_data.hasExtra("card_result3")) {
                return (ArrayList<Integer>) get_data.getSerializableExtra("card_result3");
        }
        return null;
    }

    private void cardValue(ArrayList<Integer> card_value){
        this.result_card = card_value;
        if (get_data != null && get_data.hasExtra("card_result3")) {

            _binding_result_page.resultThreeCardInclude.resultThreeCardPage.setVisibility(View.VISIBLE);
            Log.d("loglog", "ThreeCardPage" + String.valueOf(result_card));
        }
        if (get_data.hasExtra("card_result5")) {
            _binding_result_page.resultFiveCardInclude.resultFiveCardPage.setVisibility(View.VISIBLE);
            Log.d("loglog", "ThreeCardPage" + String.valueOf(result_card));
        }
        if (get_data.hasExtra("card_result8")) {
            _binding_result_page.resultEightCardInclude.resultEightCardPage.setVisibility(View.VISIBLE);
            Log.d("loglog", "ThreeCardPage" + String.valueOf(result_card));
        }
    }
}