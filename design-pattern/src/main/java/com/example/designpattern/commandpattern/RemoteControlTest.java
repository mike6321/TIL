package com.example.designpattern.commandpattern;

public class RemoteControlTest {
    public static void main(String[] args) {
        RemoteControl remote = new RemoteControl();

        Light livingRoomLight = new Light("거실");
        Light kitchenLight = new Light("부엌");
        Stereo stereo = new Stereo("거실");

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        StereoOnCommand stereoOn = new StereoOnCommand(stereo);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);

        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, kitchenLightOn, kitchenLightOff);
        remote.setCommand(2, stereoOn, stereoOff);

        System.out.println(remote);

        System.out.println("=== 리모컨 테스트 시작 ===");
        
        remote.onButtonPressed(0);
        remote.offButtonPressed(0);
        System.out.println("Undo: ");
        remote.undoButtonPressed();
        
        System.out.println();
        
        remote.onButtonPressed(1);
        remote.offButtonPressed(1);
        
        System.out.println();
        
        remote.onButtonPressed(2);
        remote.offButtonPressed(2);
        System.out.println("Undo: ");
        remote.undoButtonPressed();
    }
}