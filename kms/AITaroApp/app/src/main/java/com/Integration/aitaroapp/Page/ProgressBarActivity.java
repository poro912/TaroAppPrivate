package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.Integration.aitaroapp.R;
import com.Integration.aitaroapp.databinding.ActivityProgressBarBinding;

public class ProgressBarActivity extends AppCompatActivity {
    private ActivityProgressBarBinding _binding_progress;
    private Intent intent;
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
}