package com.example.aitaro;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class EndActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        int cardValue = intent.getIntExtra("cardValue", 0);

        textView.setText("Selected Card Value: " + cardValue);

    }
}