package com.example.java.performance;

import java.util.logging.Logger;

public class LoopExample {
    Logger logger = Logger.getLogger(LoopExample.class.getName());

    public void loopAsIs() {
        int[] data = new int[1000];
        for (int i = 0; i < data.length; i++) {

        }
    }

    public void loopToBe() {
        int[] data = new int[1000];
        int length = data.length;
        for (int i = 0; i < length; i++) {


        }
    }

    public void doSomething() {
        logger.info("Do something");
    }

}
