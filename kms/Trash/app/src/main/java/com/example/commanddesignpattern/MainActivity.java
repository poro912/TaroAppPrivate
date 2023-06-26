package com.example.commanddesignpattern;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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

interface Command {
    public void execute();
}

class Light {
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

class TV {
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

class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

class TVOnCommand implements Command {
    TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }
}

class TVOffCommand implements Command {
    TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }
}


//커맨드 지정
class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {}
    public void setCommand(Command command) {
        this.slot = command;
    }
    public void buttonWasPressed() {
        slot.execute();
    }
}