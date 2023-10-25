package com.example.aitaro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class List_main extends AppCompatActivity {

    private ListView list;
    private int cardcnt;

    @Override
    protected void onCreate(Bundle savedinstanceState) { //생명주기
        super.onCreate(savedinstanceState);
        setContentView(R.layout.main_list);

        list = (ListView) findViewById(R.id.list);
        List<String> data = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter);

        data.add("원 카드 스프레드");
        data.add("쓰리 카드 스프레드");
        data.add("켈트 십자가 스프레드");
        data.add("생명의 나무 스프레드");
        data.add("말 발굽 스프레드");
        data.add("보름달 스프레드");
        adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int num, long l) {
                switch(num){
                    case 0 : //원 카드 스프레드
                        cardcnt = 1;
                        break;
                    case 1 : //쓰리 카드 스프레드
                        cardcnt = 3;
                        break;
                    case 2 : //켈트 십자가 스프레드
                    case 3 : // 생명의 나무 스프레드
                        cardcnt = 10;
                        break;
                    case 4 : //말 발굽 스프레드
                        cardcnt = 5;
                        break;
                    case 5 : //보름달 스프레드
                        cardcnt = 6;
                        break;
                }
                Intent intent = new Intent(List_main.this, MainActivity.class);
                intent.putExtra("cardcnt", cardcnt);
                String selectedItem = data.get(num);
                intent.putExtra("selectedItem", selectedItem);
                startActivity(intent);
                
            }
        });

    }


}
