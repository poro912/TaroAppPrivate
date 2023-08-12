package com.Integration.aitaroapp.Page.Dialog;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    private MyDialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void exitApp(){
        finishAffinity();
    }

    public void showExitDialog(){
        myDialog = new MyDialog(this);
        myDialog.show();
    }
}

