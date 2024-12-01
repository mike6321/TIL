package com.example.java.performance;

import java.util.ArrayList;

public class StringExample {

    public String addStringLoop() {
        String result = "";
        String addData = "Performance";
        for (int i = 0; i < 1000; i++) {
            result += addData;
        }
        return result;
    }

    public String addString() {
        String result = "";
        String addData = "Performance";
        result += addData;
        return result;
    }


    public static void main(String[] args) {

    }

}
