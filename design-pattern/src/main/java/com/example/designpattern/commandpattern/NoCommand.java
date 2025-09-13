package com.example.designpattern.commandpattern;

public class NoCommand implements Command {
    @Override
    public void execute() {
        // 아무것도 하지 않음
    }

    @Override
    public void undo() {
        // 아무것도 하지 않음
    }
}