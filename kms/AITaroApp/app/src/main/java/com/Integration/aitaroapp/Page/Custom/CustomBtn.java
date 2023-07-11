package com.Integration.aitaroapp.Page.Custom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.Integration.aitaroapp.R;

public class CustomBtn {
    Context mc;
    LinearLayout layout;

    public CustomBtn(Context context, LinearLayout linearLayout) {
        this.mc = context;
        this.layout = linearLayout;
    }

    public void storeSettingBtn() {
        Button button = new Button(mc);
        button.setTextSize(15);
        button.setGravity(Gravity.CENTER);
        button.setBackgroundColor(Color.GRAY);
        button.setAlpha(0.3f);
       Drawable radius = mc.getResources().getDrawable(R.drawable.btn_radius);
       button.setBackground(radius);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);

        button.setLayoutParams(params);

        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mc, "동적 버튼 클릭", Toast.LENGTH_SHORT).show();


            }
        });
    }
}
