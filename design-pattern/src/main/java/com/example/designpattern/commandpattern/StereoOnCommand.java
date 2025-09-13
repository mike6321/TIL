package com.example.designpattern.commandpattern;

public class StereoOnCommand implements Command {
    private Stereo stereo;
    private int previousVolume;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}