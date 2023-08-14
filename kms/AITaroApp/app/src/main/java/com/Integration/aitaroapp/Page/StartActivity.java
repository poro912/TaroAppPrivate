package com.Integration.aitaroapp.Page;

import android.annotation.SuppressLint;
import android.opengl.Visibility;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.Integration.aitaroapp.Page.Adapter.GameSelectedRecyclerViewAdapter;
import com.Integration.aitaroapp.Page.Adapter.StoreSettingAdapter;
import com.Integration.aitaroapp.Page.Dialog.BaseActivity;
import com.Integration.aitaroapp.Page.Dialog.MyDialog;
import com.Integration.aitaroapp.Page.Item.MainBtnSelected;
import com.Integration.aitaroapp.Page.Item.StoreRecyclerViewItem;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityStartBinding;

import java.util.ArrayList;

public class StartActivity extends BaseActivity {
    private ActivityStartBinding _binding_startPage;
    private ArrayList<MainBtnSelected> btn_item = new ArrayList<>();
    boolean pageOpen = false;
    private MyDialog myDialog;
    private SlidingPageAnimationListener slidingPageAnimationListener = new SlidingPageAnimationListener();
    //스토어, 설정 페이지 애니메이션 효과적용
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
        backGroundTouchLayout();

    }

    private void mainWindowTouch() {

        _binding_startPage.includedItem.storeBtn.setVisibility(View.VISIBLE);
        _binding_startPage.cardSelectRecyclerView.setVisibility(View.VISIBLE);
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

    private void backGroundTouchLayout() {
        _binding_startPage.includedItem.blurLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true; // 터치 이벤트가 다른 곳으로 전달되도록 함
            }
        });
    }

    private void layoutAnim() {
        left_anim = AnimationUtils.loadAnimation(this, R.anim.setting_anime_left);
        right_anim = AnimationUtils.loadAnimation(this, R.anim.setting_anime_right);

        left_anim.setAnimationListener(slidingPageAnimationListener);
        right_anim.setAnimationListener(slidingPageAnimationListener);

        _binding_startPage.includedItem.storeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pageOpen) {
                    _binding_startPage.includedItem.page.startAnimation(left_anim);
                    _binding_startPage.includedItem.storeBtn.startAnimation(left_anim);
                } else {
                    _binding_startPage.includedItem.page.setVisibility(View.VISIBLE);
                    _binding_startPage.includedItem.blurLayout.setVisibility(View.VISIBLE);
                    _binding_startPage.includedItem.page.startAnimation(right_anim);
                    _binding_startPage.includedItem.storeBtn.startAnimation(right_anim);
                }
            }
        });
    }


    private void backPressedAnim() {
        left_anim = AnimationUtils.loadAnimation(StartActivity.this, R.anim.setting_anime_left);
        left_anim.setAnimationListener(slidingPageAnimationListener);

        if (pageOpen) {
            // 페이지가 열려있을 때 뒤로가기 버튼을 누르면 페이지를 닫고 pageOpen을 false로 변경
            _binding_startPage.includedItem.page.startAnimation(left_anim);
            _binding_startPage.includedItem.storeBtn.startAnimation(left_anim);
            _binding_startPage.includedItem.page.setVisibility(View.GONE);
            _binding_startPage.includedItem.blurLayout.setVisibility(View.GONE);
            pageOpen = true;
        } else {
            myDialog = new MyDialog(this);
            myDialog.show();
        }
    }

    @Override
    public void onBackPressed() {
        backPressedAnim();
    }

    @Override
    public void onExitConfirmed() {
        exitApp();
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if (pageOpen) {
                _binding_startPage.includedItem.page.setVisibility(View.GONE);
                _binding_startPage.includedItem.blurLayout.setVisibility(View.GONE);
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