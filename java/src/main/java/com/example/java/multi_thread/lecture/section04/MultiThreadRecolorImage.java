package com.example.java.multi_thread.lecture.section04;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class MultiThreadRecolorImage extends RecolorImage {

    private static final int numberOfThreads = 6;

    @Override
    protected void recolorThread(BufferedImage originImage, BufferedImage resultImage) {
        List<Thread> threads = new ArrayList<>();
        int width = originImage.getWidth();
        int height = originImage.getHeight() / numberOfThreads; // 높이를 기준으로 스레드 분할

        for (int i = 0; i < numberOfThreads; i++) {
            final int threadMultiplier = i;

            Thread thread = new Thread(() -> {
                int leftCorner = 0;
                int topCorner = height * threadMultiplier;

                recolorImage(originImage, resultImage, leftCorner, topCorner, width, height);
            });

            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
