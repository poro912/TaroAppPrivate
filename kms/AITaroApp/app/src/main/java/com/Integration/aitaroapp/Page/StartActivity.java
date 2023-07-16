package com.Integration.aitaroapp.Page;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.Integration.aitaroapp.Page.Adapter.GameSelectedRecyclerViewAdapter;
import com.Integration.aitaroapp.Page.Adapter.StoreSettingAdapter;
import com.Integration.aitaroapp.Page.Item.MainBtnSelected;
import com.Integration.aitaroapp.Page.Item.StoreRecyclerViewItem;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityStartBinding;
import jp.wasabeef.blurry.Blurry;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {
    private ActivityStartBinding _binding_startPage;
    private ArrayList<MainBtnSelected> btn_item = new ArrayList<>();
    boolean pageOpen = false;
    Animation left_anim;
    Animation right_anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_startPage = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(_binding_startPage.getRoot());

        init();

    }

    private void init() {
        mainWindowTouch();
        recyclerViewItem();
        storeRecyclerView();
        layoutAnim();
    }

    private void mainWindowTouch() {
        _binding_startPage.startImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _binding_startPage.includedItem.storeBtn.setVisibility(View.VISIBLE);
                _binding_startPage.startImage.setVisibility(View.GONE);
                _binding_startPage.cardSelectRecyclerView.setVisibility(View.VISIBLE);
            }
        });
    }

    private void recyclerViewItem() {
        //게임 시작 전 리사이클러뷰 셀렉페이지
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        _binding_startPage.cardSelectRecyclerView.setLayoutManager(linearLayoutManager);
        GameSelectedRecyclerViewAdapter mainRecyclerViewAdapter = new GameSelectedRecyclerViewAdapter(btn_item);
        _binding_startPage.cardSelectRecyclerView.setAdapter(mainRecyclerViewAdapter);

        btn_item.add(new MainBtnSelected("threeCard"));
        btn_item.add(new MainBtnSelected("fiveCard"));
        btn_item.add(new MainBtnSelected("eightCard"));
    }

    private void storeRecyclerView() {
        //storeRecyclerView
        ArrayList<StoreRecyclerViewItem> itemData = new ArrayList<>();
        // 아이템 넣기
        itemData.add(new StoreRecyclerViewItem(R.drawable.close_icon, "카드 구매"));
        itemData.add(new StoreRecyclerViewItem(R.drawable.add_icon, "스프레드 구매"));
        itemData.add(new StoreRecyclerViewItem(R.drawable.ic_launcher_foreground, "배경 구매"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        StoreSettingAdapter storeSettingAdapter = new StoreSettingAdapter(itemData);

        _binding_startPage.includedItem.storeRecyclerView.setLayoutManager(linearLayoutManager);
        _binding_startPage.includedItem.storeRecyclerView.setAdapter(storeSettingAdapter);

    }
    
    private void layoutAnim() {
        //스토어, 설정 페이지 애니메이션 효과적용
        left_anim = AnimationUtils.loadAnimation(this, R.anim.setting_anime_left);
        right_anim = AnimationUtils.loadAnimation(this, R.anim.setting_anime_right);

        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();

        left_anim.setAnimationListener(animationListener);
        right_anim.setAnimationListener(animationListener);

        _binding_startPage.includedItem.storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageOpen)
                {
                    _binding_startPage.includedItem.page.startAnimation(left_anim);
                    _binding_startPage.includedItem.storeBtn.startAnimation(left_anim);
                }
                else
                {
                    _binding_startPage.includedItem.page.setVisibility(View.VISIBLE);
                    _binding_startPage.includedItem.page.startAnimation(right_anim);
                    _binding_startPage.includedItem.storeBtn.startAnimation(right_anim);
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
            if (pageOpen)
            {
                _binding_startPage.includedItem.page.setVisibility(View.GONE);
                pageOpen = false;
            }
            else
            {
                pageOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}