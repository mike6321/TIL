package com.example.java.multi_thread.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Set;

@Slf4j
public class ThreadUtil {

    private static final String DIVISION = ">>>>>>>>>>>>>>>>>>>>>>>>>>>>";

    public static void getThreadInfo(String name) {
        String division = DIVISION + " " + name + " " + DIVISION;
        Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        System.out.println(division);
        threadSet.stream()
                .filter(thread -> thread.getName().startsWith("Thread") || thread.getName().startsWith("main"))
                .forEach(thread -> log.debug("[{}] - {} : {}", name, thread.getName(), thread.getState()));
        System.out.println(division);
    }

}
