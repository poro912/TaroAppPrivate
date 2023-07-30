package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_result_page = ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(_binding_result_page.getRoot());

        get_data = getIntent();

        init();
    }

    private void init() {
        handleReceivedArrayList();
        btnItem();
    }


    private void handleReceivedArrayList() {
        result_card = getReceivedArrayList();
        if (get_data.hasExtra("card_result3")) {
            _binding_result_page.resultThreeCardInclude.resultThreeCardPage.setVisibility(View.VISIBLE);

            Log.d("loglog", "ThreeCardPage" + String.valueOf(result_card));
        }
        if (get_data.hasExtra("card_result5")) {
            _binding_result_page.resultFiveCardInclude.resultFiveCardPage.setVisibility(View.VISIBLE);

            Log.d("loglog", "FiveCardPage" + String.valueOf(result_card));
        }
        if (get_data.hasExtra("card_result8")) {
            _binding_result_page.resultEightCardInclude.resultEightCardPage.setVisibility(View.VISIBLE);

            Log.d("loglog", "EightCardPage" + String.valueOf(result_card));
        }
    }

    private ArrayList<Integer> getReceivedArrayList() {
        if (get_data != null && get_data.hasExtra("card_result3")) {
            return (ArrayList<Integer>) get_data.getSerializableExtra("card_result3");
        }
        if (get_data != null && get_data.hasExtra("card_result5")) {
            return (ArrayList<Integer>) get_data.getSerializableExtra("card_result5");
        }
        if (get_data != null && get_data.hasExtra("card_result8")) {
            return (ArrayList<Integer>) get_data.getSerializableExtra("card_result8");
        }
        return null;
    }

    private void btnItem(){
        _binding_result_page.resultShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ResultActivity.this, "카카오톡 공유하기", Toast.LENGTH_SHORT).show();
            }
        });

        _binding_result_page.mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move_activity = new Intent(ResultActivity.this, StartActivity.class);
                startActivity(move_activity);
            }
        });
    }
}