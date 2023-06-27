package com.example.commanddesignpattern.Tv;

import android.content.Context;
import android.util.Log;

public class TV {
    Context mContext;

    public TV(Context context){
        mContext = context;
    }

    public void on(){
        Log.d("CommandTest", "TV ON");
    }

    public void off(){
        Log.d("CommandTest", "TV OFF");
    }
}