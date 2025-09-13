package com.example.designpattern.commandpattern;

public class Stereo {
    private boolean isOn = false;
    private int volume = 0;
    private String location;

    public Stereo(String location) {
        this.location = location;
    }

    public void on() {
        isOn = true;
        System.out.println(location + " 스테레오가 켜졌습니다.");
    }

    public void off() {
        isOn = false;
        volume = 0;
        System.out.println(location + " 스테레오가 꺼졌습니다.");
    }

    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println(location + " 스테레오 볼륨이 " + volume + "로 설정되었습니다.");
    }

    public boolean isOn() {
        return isOn;
    }

    public int getVolume() {
        return volume;
    }
}