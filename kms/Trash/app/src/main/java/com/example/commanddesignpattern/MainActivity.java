package com.example.commanddesignpattern;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.commanddesignpattern.Interface.Command;
import com.example.commanddesignpattern.Light.Light;
import com.example.commanddesignpattern.Light.LightOffCommand;
import com.example.commanddesignpattern.Light.LightOnCommand;
import com.example.commanddesignpattern.RemoteControl.SimpleRemoteControl;
import com.example.commanddesignpattern.Tv.TV;
import com.example.commanddesignpattern.Tv.TVOffCommand;
import com.example.commanddesignpattern.Tv.TVOnCommand;
import com.example.commanddesignpattern.databinding.ActivityMainBinding;

import java.util.EmptyStackException;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    SimpleRemoteControl simpleRemoteControl;
    Command nowCommand;

    Stack<Command> usedCommandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        simpleRemoteControl = new SimpleRemoteControl();
    }

    private void init() {
        Button buttonA = findViewById(R.id.lightOn);
        buttonA.setOnClickListener(this);

        Button buttonB = findViewById(R.id.lightOff);
        buttonB.setOnClickListener(this);

        Button buttonC = findViewById(R.id.TvOn);
        buttonC.setOnClickListener(this);

        Button buttonD = findViewById(R.id.TvOff);
        buttonD.setOnClickListener(this);

        Button buttonUndo = findViewById(R.id.allOff);
        buttonUndo.setOnClickListener(this);

        usedCommandList = new Stack<Command>();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.lightOn:
                nowCommand = new LightOnCommand(new Light(this));
                simpleRemoteControl.setCommand(nowCommand);
                simpleRemoteControl.buttonWasPressed();
                usedCommandList.add(nowCommand);
                break;
            case R.id.lightOff:
                nowCommand = new LightOffCommand(new Light(this));
                simpleRemoteControl.setCommand(nowCommand);
                simpleRemoteControl.buttonWasPressed();
                usedCommandList.add(nowCommand);
                break;
            case R.id.TvOn:
                nowCommand = new TVOnCommand(new TV(this));
                simpleRemoteControl.setCommand(nowCommand);
                simpleRemoteControl.buttonWasPressed();
                usedCommandList.add(nowCommand);
                break;
            case R.id.TvOff:
                nowCommand = new TVOffCommand(new TV(this));
                simpleRemoteControl.setCommand(nowCommand);
                simpleRemoteControl.buttonWasPressed();
                usedCommandList.add(nowCommand);
                break;
            case R.id.allOff:
                try{
                    nowCommand = usedCommandList.pop();
                    if(nowCommand != null){
                        simpleRemoteControl.setCommand(nowCommand);
                        simpleRemoteControl.buttonWasPressed();
                    }
                }catch(EmptyStackException e){
                    Log.d("CommandTest", "No more undo command");
                }
                break;
        }
    }
}