package com.example.java.multi_thread.lecture.section04;

import java.awt.image.BufferedImage;

public class SingleThreadRecolorImage extends RecolorImage {

    @Override
    protected void recolorThread(BufferedImage originImage, BufferedImage resultImage) {
        recolorImage(originImage, resultImage, 0, 0, originImage.getWidth(), originImage.getHeight());
    }

}
