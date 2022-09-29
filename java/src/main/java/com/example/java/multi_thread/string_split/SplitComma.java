package com.example.java.multi_thread.string_split;

public class SplitComma {

    public static void main(String[] args) {
        SplitComma splitComma = new SplitComma();
        splitComma.splitComma("test1, test2");
    }

    public String splitComma(String str) {
        String[] splitStr = str.split(",");
        return null;
    }

}
