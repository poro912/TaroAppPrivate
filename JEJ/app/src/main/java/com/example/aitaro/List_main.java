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
    private int cardcut;

    @Override
    protected void onCreate(Bundle savedinstanceState) { //생명주기
        super.onCreate(savedinstanceState);
        setContentView(R.layout.main_list);

        list = (ListView) findViewById(R.id.list);
        List<String> date = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, date);
        list.setAdapter(adapter);

        date.add("원 카드 스프레드");
        date.add("쓰리 카드 스프레드");
        date.add("켈트 십자가 스프레드");
        date.add("생명의 나무 스프레드");
        date.add("말 발굽 스프레드");
        date.add("보름달 스프레드");
        adapter.notifyDataSetChanged();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int num, long l) {
                switch(num){
                    case 0 :
                        cardcut = 1;
                        break;
                    case 1 :
                        cardcut = 3;
                        break;
                    case 2 :
                        cardcut = 10;
                        break;
                    case 2 :
                        cardcut = 10;
                        break;
                    case 2 :
                        cardcut = 10;
                        break;
                    case 2 :
                        cardcut = 10;
                        break;
                    case 2 :
                        cardcut = 10;
                        break;


                }
                Intent intent = new Intent(List_main.this, MainActivity.class);
                intent.putExtra("cardcut", cardcut);
                String selectedItem = date.get(num);
                intent.putExtra("selectedItem", selectedItem);
                startActivity(intent);

                if (i == 0) { // 1번째 클릭시
                    cardcut = 1;
                    Intent intent = new Intent(List_main.this, MainActivity.class);
                    intent.putExtra("cardcut", cardcut);
                    String selectedItem = date.get(num);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                }
                if (i == 1) { // 2번째 클릭시
                    cardcut = 3;
                    Intent intent = new Intent(List_main.this, MainActivity.class);
                    intent.putExtra("cardcut", cardcut);
                    String selectedItem = date.get(num);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                }
                if (i == 2) { // 3번째 클릭시
                    cardcut = 10;
                    Intent intent = new Intent(List_main.this, MainActivity.class);
                    intent.putExtra("cardcut", cardcut);
                    String selectedItem = date.get(num);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                }
                if (i == 3) { // 4번째 클릭시
                    cardcut = 10;
                    Intent intent = new Intent(List_main.this, MainActivity.class);
                    intent.putExtra("cardcut", cardcut);
                    String selectedItem = date.get(num);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                }
                if (i == 4) { // 5번째 클릭시
                    cardcut = 5;
                    Intent intent = new Intent(List_main.this, MainActivity.class);
                    intent.putExtra("cardcut", cardcut);
                    String selectedItem = date.get(num);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                }
                if (i == 5) { // 6번째 클릭시
                    cardcut = 6;
                    Intent intent = new Intent(List_main.this, MainActivity.class);
                    intent.putExtra("cardcut", cardcut);
                    String selectedItem = date.get(num);
                    intent.putExtra("selectedItem", selectedItem);
                    startActivity(intent);
                }
            }
        });

    }


}
