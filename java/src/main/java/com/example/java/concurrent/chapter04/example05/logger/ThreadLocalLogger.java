package com.example.java.concurrent.chapter04.example05.logger;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ThreadLocalLogger {

    private static final ThreadLocal<List<String>> THREAD_LOG = ThreadLocal.withInitial(ArrayList::new);

    public static void addLog(String log) {
        THREAD_LOG.get().add(log);
    }

    public static void printLogs() {
        List<String> logs = THREAD_LOG.get();
        log.info("{}", String.join("->", logs));
    }

    public static void clearLogs() {
        THREAD_LOG.remove();
    }

    static class ServiceA {

        public void process() {
            addLog("ServiceA 작업을 수행중입니다.");
        }

    }

    static class ServiceB {

        public void process() {
            addLog("ServiceB 작업을 수행중입니다.");
        }

    }

    static class ServiceC {

        public void process() {
            addLog("ServiceC 작업을 수행중입니다.");
        }

    }

}
