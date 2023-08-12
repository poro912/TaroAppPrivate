package com.Integration.aitaroapp.Page.Dialog;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;

public class BaseActivity extends AppCompatActivity implements ExitDialogListener {
    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void exitApp(){
        finishAffinity();
    }

    @Override
    public void onExitConfirmed() {
        exitApp();
    }
}

