package com.example.java.multi_thread.lecture.section04;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main01 {

    public static final String SOURCE_FILE = "./in/many-flowers.jpg";
    public static final String DESTINATION_FILE = "./out/many-flowers.jpg";

    public static void main(String[] args) throws IOException {
        BufferedImage originImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originImage.getWidth(), originImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        RecolorImage singleThreadRecolorImage = new SingleThreadRecolorImage();
        executeSingleThread(originImage, resultImage, singleThreadRecolorImage);
        executeMultiThread(originImage, resultImage);
    }

    private static void executeSingleThread(BufferedImage originImage, BufferedImage resultImage, RecolorImage singleThreadRecolorImage) throws IOException {
        long startTime = System.currentTimeMillis();
        singleThreadRecolorImage.recolorThread(originImage, resultImage);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        File outputFile = new File(DESTINATION_FILE);
        ImageIO.write(resultImage, "jpg", outputFile);

        System.out.println("single thread duration :: " + duration);
    }

    private static void executeMultiThread(BufferedImage originImage, BufferedImage resultImage) throws IOException {
        RecolorImage multiThreadRecolorImage = new MultiThreadRecolorImage();
        long startTime = System.currentTimeMillis();
        multiThreadRecolorImage.recolorThread(originImage, resultImage);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        File outputFile = new File(DESTINATION_FILE);
        ImageIO.write(resultImage, "jpg", outputFile);

        System.out.println("multi thread duration :: " + duration);
    }

}
