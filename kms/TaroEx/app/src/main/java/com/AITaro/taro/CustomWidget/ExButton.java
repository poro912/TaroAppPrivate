package com.AITaro.taro.CustomWidget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.AITaro.taro.R;

public class ExButton{
    Context mcContext;
    LinearLayout linearLayout;


    public ExButton(Context context, LinearLayout linearLayout) {
        this.mcContext = context;
        this.linearLayout = linearLayout;



    }

    public void CustomBtn() {
        Button button = new Button(mcContext);
        button.setText("동적버튼");
        button.setTextSize(15);
        button.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        button.setLayoutParams(params);

        linearLayout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcContext, "동적 버튼 클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
