package com.AITaro.taro;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
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

        nextPage();
        selectCard();
        preparing();
    }//onCreate

    private void selectCard() {
        s_Binding.startImage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                s_Binding.startImage.setVisibility(View.GONE);
                s_Binding.linearLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    private void nextPage() {
        s_Binding.tenCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void preparing(){
        s_Binding.fiftyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartPage.this, "준비중1", Toast.LENGTH_SHORT).show();
            }
        });

        s_Binding.sixtyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StartPage.this, "준비중2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}