package com.example.commanddesignpattern.Tv;

import com.example.commanddesignpattern.Interface.Command;

public class TVOnCommand implements Command {
    TV tv;

    public TVOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }
}