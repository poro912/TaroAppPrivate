package com.example.commanddesignpattern.RemoteControl;

import com.example.commanddesignpattern.Interface.Command;

//커맨드 지정
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {}
    public void setCommand(Command command) {
        this.slot = command;
    }
    public void buttonWasPressed() {
        slot.execute();
    }
}