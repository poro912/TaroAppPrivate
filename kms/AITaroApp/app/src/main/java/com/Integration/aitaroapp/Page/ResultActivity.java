package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.os.Bundle;
import com.Integration.aitaroapp.Page.Dialog.MyDialog;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityResultBinding;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ResultActivity extends BaseActivity implements ExitDialogListener.Finished {
    private ActivityResultBinding _binding_result_page;
    private Intent get_data;
    private ArrayList<Integer> result_card = new ArrayList<>();     //결과 카드들을 담을 ArrayList
    private MyDialog myDialog;
    private boolean is_front = false;
    private static final String draw_card_image = "taro_";
    private int[] threeCardHolderViewId = {
            R.id.result_three_pos0,
            R.id.result_three_pos1,
            R.id.result_three_pos2
    };
    private int[] fiveCardHolderViewId = {
            R.id.result_five_pos0,
            R.id.result_five_pos1,
            R.id.result_five_pos2,
            R.id.result_five_pos3,
            R.id.result_five_pos4

    };
    private int[] eightCardHolderViewId = {
            R.id.result_eight_pos0,
            R.id.result_eight_pos1,
            R.id.result_eight_pos2,
            R.id.result_eight_pos3,
            R.id.result_eight_pos4,
            R.id.result_eight_pos5,
            R.id.result_eight_pos6,
            R.id.result_eight_pos7
    };


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
        showCardImage();
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

        _binding_result_page.resultThreeCardInclude.resultThreePos0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String list_value = result_card.get(0).toString();
                Toast.makeText(ResultActivity.this, list_value, Toast.LENGTH_SHORT).show();

            }
        });
        _binding_result_page.resultThreeCardInclude.resultThreePos1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        _binding_result_page.resultThreeCardInclude.resultThreePos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result_card.get(2);

            }
        });
    }

    private void showCardImage() {
        //카드 이미지 번호 가져오기

        for (int i = 0; i < result_card.size(); i++) {
            String cardValue = draw_card_image + i;
            int resource_id = getResources().getIdentifier(cardValue, "drawable", getPackageName());
            String resourceName = "_binding_result_page.resultThreeCardInclude.resultThreePos" + i;

            int viewId = getResources().getIdentifier(resourceName, "id", getPackageName());
            Log.d("loglog", "viewId : " + viewId);

            if (viewId != 0) {

                ImageView imageView = findViewById(viewId);
                Log.d("loglog", "imageView : " + imageView);

                if (imageView != null) {
                    imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            imageView.setImageResource(resource_id);
                            Log.d("loglog", "imageViewClick" + imageView);
                            Log.d("loglog", "v" + v);
                        }
                    });

                }
            }

          /*  if (resource_id != 0) {
                _binding_result_page.resultThreeCardInclude.resultThreePos0.setImageResource(resource_id);
            }*/
        }

    }

    @Override
    public void onBackPressed() {
        programExit();
    }

    @Override
    public void onFinishActivity() {
        super.onFinishActivity();
    }
}