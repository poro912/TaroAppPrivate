package com.example.commanddesignpattern.Light;

import android.content.Context;
import android.util.Log;

public class Light {
    Context mContext;

    public Light(Context context){
        mContext = context;
    }

    public void on(){
        Log.d("CommandTest", "Light ON");
    }

    public void off(){
        Log.d("CommandTest", "Light OFF");
    }
}