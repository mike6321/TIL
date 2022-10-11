package com.example.java.multi_thread.lecture.section04;

import java.awt.image.BufferedImage;

public abstract class RecolorImage {

    protected abstract void recolorThread(BufferedImage originImage, BufferedImage resultImage);

    private void recolorPixel(BufferedImage originImage, BufferedImage resultImage, int x, int y) {
        int rgb = originImage.getRGB(x, y);

        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed;
        int newGreen;
        int newBlue;

        if (isShadeOfGray(red, green, blue)) {
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);
        } else {
            newRed = red;
            newGreen = green;
            newBlue = blue;
        }

        int newRgb = createRgbFromColors(newRed, newGreen, newBlue);
        setRgb(resultImage, x, y, newRgb);
    }

    protected void recolorImage(BufferedImage originImage, BufferedImage resultImage, int leftCorner, int topCorner, int width, int height) {
        for(int x = leftCorner ; x < leftCorner + width && x < originImage.getWidth() ; x++) {
            for(int y = topCorner ; y < topCorner + height && y < originImage.getHeight() ; y++) {
                recolorPixel(originImage, resultImage, x , y);
            }
        }
    }

    private void setRgb(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }

    private boolean isShadeOfGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30 && Math.abs( green - blue) < 30;
    }

    private int createRgbFromColors(int red, int green, int blue) {
        int rgb = 0;

        rgb |= blue;
        rgb |= green << 8;
        rgb |= red << 16;

        rgb |= 0xFF000000;

        return rgb;
    }

    private int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    private int getGreen(int rgb) {
        return (rgb & 0x0000FF00) >> 8;
    }

    private int getBlue(int rgb) {
        return rgb & 0x000000FF;
    }
    
}
