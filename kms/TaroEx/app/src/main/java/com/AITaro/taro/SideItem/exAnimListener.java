package com.AITaro.taro.SideItem;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import com.AITaro.taro.MainActivity;
import com.AITaro.taro.R;

public class exAnimListener {
    private Context mContext;
    Animation leftAnim;
    Animation rightAnim;

    boolean pageOpen = false;
    View mV;

    public exAnimListener(Context context, Button button) {
        super();
        mContext = context;


        leftAnim = AnimationUtils.loadAnimation(mContext, R.anim.setting_anime_left);
        rightAnim = AnimationUtils.loadAnimation(mContext, R.anim.setting_anime_right);

        SlidingPageAnimationListener animation = new SlidingPageAnimationListener(mContext);


        leftAnim.setAnimationListener(animation);
        rightAnim.setAnimationListener(animation);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (mV != null) {
                        if (pageOpen) {
                            v.startAnimation(leftAnim);
                        } else {
                            v.setVisibility(View.VISIBLE);
                            v.startAnimation(rightAnim);
                        }

                        if (!pageOpen) {
                            mV.setVisibility(View.INVISIBLE);
                            pageOpen = false;
                        } else {
                            pageOpen = true;
                        }
                    }else {
                        Log.d("loglog", String.valueOf(mV));
                    }
                } catch (Exception e) {
                    Log.d("loglog", "tqtq");
                    e.printStackTrace();
                }
            }
        });
    }

    class SlidingPageAnimationListener implements Animation.AnimationListener {
        public SlidingPageAnimationListener(Context context) {
            mContext = context;
        }

            @Override
            public void onAnimationStart (Animation animation){

            }

            @Override
            public void onAnimationEnd (Animation animation){

            }

            @Override
            public void onAnimationRepeat (Animation animation){

            }

    }
}
