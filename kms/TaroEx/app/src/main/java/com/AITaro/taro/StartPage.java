package com.AITaro.taro;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.AITaro.taro.Items.RecyclerViewItem;
import com.AITaro.taro.databinding.ActivityStartPageBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StartPage extends AppCompatActivity implements Serializable {
    private ActivityStartPageBinding s_Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        s_Binding = ActivityStartPageBinding.inflate(getLayoutInflater());
        setContentView(s_Binding.getRoot());

        nextPage(10);
        selectCard();
    }//onCreate

    private void selectCard() {
        s_Binding.startImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s_Binding.linearLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void nextPage(int num) {
        int Num = num;
        int finalNum = Num;
        s_Binding.tenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                Random random = new Random();

                List<Integer> str = new ArrayList<>();
                int num;
                for (int i = 0; i < finalNum; i++) {
                    while (true) {
                        num = random.nextInt(87) + 1;

                        if (str.contains(num)) {
                            continue;
                        } else {
                            str.add(num);
                            break;
                        }
                    }
                }

                intent.putIntegerArrayListExtra("s", (ArrayList<Integer>) str);

                startActivity(intent);
                finish();
            }
        });
    }
}