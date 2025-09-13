package com.example.designpattern.commandpattern;

public class Light {
    private boolean isOn = false;
    private String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(location + " 조명이 켜졌습니다.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(location + " 조명이 꺼졌습니다.");
    }

    public boolean isOn() {
        return isOn;
    }
}