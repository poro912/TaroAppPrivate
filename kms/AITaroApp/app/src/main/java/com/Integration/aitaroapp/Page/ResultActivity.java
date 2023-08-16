package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import android.os.Bundle;
import com.Integration.aitaroapp.Page.Dialog.BaseActivity;
import com.Integration.aitaroapp.Page.Dialog.MyDialog;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityResultBinding;

import java.util.ArrayList;

import static com.Integration.aitaroapp.Page.MainActivity.back_pressed_time;

public class ResultActivity extends BaseActivity implements ExitDialogListener.Finished {
    private ActivityResultBinding _binding_result_page;
    private Intent get_data;
    private ArrayList<Integer> result_card = new ArrayList<>();     //결과 카드들을 담을 ArrayList
    private MyDialog myDialog;
    private boolean is_front = false;


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
        cardValue();
        cardClickAnim(_binding_result_page.resultThreeCardInclude.resultThreePos1Card);
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

    private void btnItem() {
       
        _binding_result_page.resultShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ResultActivity.this, "카카오톡 공유하기", Toast.LENGTH_SHORT).show();
            }
        });

        _binding_result_page.mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog = new MyDialog(ResultActivity.this);
                myDialog.show();
                myDialog.dialogBtn("back_pressed");

            }


        });
    }

    private void cardValue() {
        _binding_result_page.resultThreeCardInclude.resultThreePos1Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list_value = result_card.get(0).toString();
                Toast.makeText(ResultActivity.this, list_value, Toast.LENGTH_SHORT).show();

            }
        });
        _binding_result_page.resultThreeCardInclude.resultThreePos2Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list_value = result_card.get(1).toString();
                Toast.makeText(ResultActivity.this, list_value, Toast.LENGTH_SHORT).show();
            }
        });
        _binding_result_page.resultThreeCardInclude.resultThreePos3Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list_value = result_card.get(2).toString();
                Toast.makeText(ResultActivity.this, list_value, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void cardClickAnim(View view){
        Animation flipAnimation = AnimationUtils.loadAnimation(this, R.anim.card_anim_reverse);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.startAnimation(flipAnimation);

                if (is_front){
                    view.setBackgroundResource(R.drawable.back_taro_card);
                }else {
                    view.setBackgroundResource(R.drawable.back_taro_card);
                }
                is_front = false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > back_pressed_time + 2000) {
            back_pressed_time = System.currentTimeMillis();
            Toast.makeText(this, "메인화면으로 돌아갈까요?", Toast.LENGTH_SHORT).show();
        } else if (System.currentTimeMillis() <= back_pressed_time + 2000) {
            finish();
        }
    }

    @Override
    public void onFinishActivity() {
        super.onFinishActivity();
    }
}