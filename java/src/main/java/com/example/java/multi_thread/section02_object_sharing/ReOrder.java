package com.example.java.multi_thread.section02_object_sharing;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReOrder {

    private int a = 2;
    private boolean flag = false;

    public void method01() {
        a = 1;
        flag = true;
    }

    public void method02() {
        if (flag) {
            log.info("a = {}", a);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            ReOrder reOrder = new ReOrder();
            Thread tread01 = new Thread(() -> {
                reOrder.method01();
            });
            Thread tread02 = new Thread(() -> {
                reOrder.method02();
            });
            tread01.start();
            tread02.start();
        }
    }

}
