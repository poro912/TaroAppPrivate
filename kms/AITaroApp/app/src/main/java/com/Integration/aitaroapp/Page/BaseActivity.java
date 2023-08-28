package com.Integration.aitaroapp.Page;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.Integration.aitaroapp.Page.Dialog.MyDialog;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;
import com.Integration.aitaroapp.Page.StartActivity;

public class BaseActivity extends AppCompatActivity implements ExitDialogListener,ExitDialogListener.Finished {
    private long back_pressed_time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //앱 종료
    public void exitApp(){
        finishAffinity();
    }

    //액티비티 종료
    public void finished(){
        this.finish();
    }

    //두번 눌러 종료
    public void programExit(){
        if (System.currentTimeMillis() > back_pressed_time + 2000) {
            back_pressed_time = System.currentTimeMillis();
            Toast.makeText(this, "메인화면으로 돌아갈까요?", Toast.LENGTH_SHORT).show();
        } else if (System.currentTimeMillis() <= back_pressed_time + 2000) {
            finish();
        }
    }

    @Override
    public void onExitConfirmed() {
        exitApp();
    }

    @Override
    public void onFinishActivity() {
        finished();
    }
}

