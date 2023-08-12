package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.Integration.aitaroapp.Page.Dialog.MyDialog;
import com.Integration.aitaroapp.databinding.ActivityProgressBarBinding;

public class ProgressBarActivity extends AppCompatActivity {
    private ActivityProgressBarBinding _binding_progress;
    private Intent intent;
    private long backpressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _binding_progress = ActivityProgressBarBinding.inflate(getLayoutInflater());
        setContentView(_binding_progress.getRoot());

        init();
    }

    private void init() {
        startProgressBar();
    }

    private void startProgressBar() {
        intent = new Intent(this, StartActivity.class);
        _binding_progress.startImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backpressedTime + 2000) {
            backpressedTime = System.currentTimeMillis();
            Toast.makeText(this, "한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        } else if (System.currentTimeMillis() <= backpressedTime + 2000) {
            finish();
        }
    }
}