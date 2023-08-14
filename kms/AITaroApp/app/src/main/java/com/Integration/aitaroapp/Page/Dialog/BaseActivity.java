package com.Integration.aitaroapp.Page.Dialog;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;
import com.Integration.aitaroapp.Page.StartActivity;

public class BaseActivity extends AppCompatActivity implements ExitDialogListener,ExitDialogListener.Finished {
    private MyDialog myDialog;

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

    @Override
    public void onExitConfirmed() {
        exitApp();
    }

    @Override
    public void onFinishActivity() {
        finished();
    }
}

