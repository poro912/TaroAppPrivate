package com.AITaro.taro;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.AITaro.taro.Adapter.CardListAdapter;
import com.AITaro.taro.Adapter.StoreSettingAdapter;
import com.AITaro.taro.Items.RecyclerViewItem;
import com.AITaro.taro.Items.StoreRecyclerViewItem;
import com.AITaro.taro.SideItem.Setting_StoreActivity;
import com.AITaro.taro.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding b_main;
    private CardListAdapter cardListAdapter;

    private boolean floatingOpen = false;
    boolean pageOpen = false;
    Animation leftAnim;
    Animation rightAnim;

    LinearLayout zzz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b_main = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b_main.getRoot());

        init();
        getData();
        clickItem();
        animationPage();

    }//endOfClass

    void init() {
        //카드 뿌리기
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        b_main.cardRecyclerView.setLayoutManager(gridLayoutManager);

        cardListAdapter = new CardListAdapter();
        b_main.cardRecyclerView.setAdapter(cardListAdapter);

        //storeRecyclerView
        ArrayList<StoreRecyclerViewItem> itemData = new ArrayList<>();
        // 아이템 넣기
        itemData.add(new StoreRecyclerViewItem(R.drawable.close_icon, "카드 구매"));
        itemData.add(new StoreRecyclerViewItem(R.drawable.add_icon, "스프레드 구매"));
        itemData.add(new StoreRecyclerViewItem(R.drawable.ic_launcher_foreground, "배경 구매"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        StoreSettingAdapter storeSettingAdapter = new StoreSettingAdapter(itemData);

        b_main.storeRecyclerView.setLayoutManager(linearLayoutManager);
        b_main.storeRecyclerView.setAdapter(storeSettingAdapter);
    }

    private void getData() {
        RecyclerViewItem data = new RecyclerViewItem();

        List<Integer> imageList = Arrays.asList(
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
        );

        for (int i = 0; i < imageList.size(); i++) {
            data.setTaroImage(imageList.get(i));
            cardListAdapter.addItem(data);
        }
    }


    //플로팅 바
    private void floatingBar() {

        //액션 버튼 닫기 - 열려있는 버튼 집어넣기
        if (floatingOpen) {
            ObjectAnimator.ofFloat(b_main.floatingStore, "translationY", 0f).start();
            ObjectAnimator.ofFloat(b_main.floatingSetting, "translationY", 0f).start();

            //플로팅 이미지 변경
            b_main.floatingBar.setImageResource(R.drawable.add_icon);

        } else {
            ObjectAnimator.ofFloat(b_main.floatingStore, "translationY", -200f).start();
            ObjectAnimator.ofFloat(b_main.floatingSetting, "translationY", -400f).start();


            b_main.floatingBar.setImageResource(R.drawable.close_icon);
        }
        floatingOpen = !floatingOpen;
    }

    private void clickItem() {

        //플로팅 버튼 클릭
        b_main.floatingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                floatingBar();
            }
        });
        //세팅 페이지 이동
        b_main.floatingSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting = new Intent(MainActivity.this, Setting_StoreActivity.class);
                startActivity(intentSetting);
            }
        });

        //스토어 페이지 이동
        b_main.floatingStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStore = new Intent(MainActivity.this, Setting_StoreActivity.class);
                startActivity(intentStore);
            }
        });

        //스토어버튼
       /* b_main.storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentStore = new Intent(MainActivity.this, Setting_StoreActivity.class);
                intentStore.putExtra("store", "store");
                startActivity(intentStore);
            }
        });*/

        //세팅버튼
        b_main.settingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSetting = new Intent(MainActivity.this, Setting_StoreActivity.class);
                intentSetting.putExtra("setting", "setting");
                startActivity(intentSetting);
            }
        });
    }

    void animationPage() {
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.setting_anime_left);
        rightAnim = AnimationUtils.loadAnimation(this, R.anim.setting_anime_right);

        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener();

        leftAnim.setAnimationListener(animListener);
        rightAnim.setAnimationListener(animListener);

        b_main.aaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageOpen) {
                    b_main.page.startAnimation(leftAnim);
                } else {
                    b_main.page.setVisibility(View.VISIBLE);
                    b_main.page.startAnimation(rightAnim);
                }
            }
        });
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (pageOpen) {
                b_main.page.setVisibility(View.INVISIBLE);
                pageOpen = false;
            } else {
                pageOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}