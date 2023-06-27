package com.example.commanddesignpattern.Light;

import com.example.commanddesignpattern.Interface.Command;

public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}