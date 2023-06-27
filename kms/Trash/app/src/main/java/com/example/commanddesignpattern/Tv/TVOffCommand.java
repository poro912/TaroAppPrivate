package com.example.commanddesignpattern.Tv;

import com.example.commanddesignpattern.Interface.Command;

public class TVOffCommand implements Command {
    TV tv;

    public TVOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.off();
    }
}