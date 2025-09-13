package com.example.designpattern.commandpattern;

public class RemoteControl {
    private Command[] onCommands;
    private Command[] offCommands;
    private Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
        undoCommand = noCommand;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void offButtonPressed(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void undoButtonPressed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------ 리모컨 ------\n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuilder.append("[slot ").append(i).append("] ")
                    .append(onCommands[i].getClass().getSimpleName())
                    .append("    ")
                    .append(offCommands[i].getClass().getSimpleName())
                    .append("\n");
        }
        stringBuilder.append("[undo] ").append(undoCommand.getClass().getSimpleName()).append("\n");
        return stringBuilder.toString();
    }
}