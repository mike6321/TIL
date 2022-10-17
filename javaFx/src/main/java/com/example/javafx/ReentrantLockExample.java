package com.example.javafx;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Cryptocurrency Prices");

        GridPane grid = SettingProperties.createGrid();
        Map<String, Label> cryptoLabels = SettingProperties.createCryptoPriceLabels();

        Rectangle background = chore(primaryStage, grid, cryptoLabels);

        PriceContainer pricesContainer = new PriceContainer();
        PriceUpdater priceUpdater = new PriceUpdater(pricesContainer);

        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // step 01 : use lock
//                pricesContainer.getLockObject().lock();
//                try {
//                    setLabel(cryptoLabels, pricesContainer);
//                } finally {
//                    pricesContainer.getLockObject().unlock();
//                }
                // step 02 : use tryLock
                if (pricesContainer.getLockObject().tryLock()) {
                    try {
                        setLabel(cryptoLabels, pricesContainer);
                    } finally {
                        pricesContainer.getLockObject().unlock();
                    }
                }
            }
        };

        SettingProperties.addWindowResizeListener(primaryStage, background);
        animationTimer.start(); // ui 스레드
        priceUpdater.start(); // price 스레드
        primaryStage.show();
    }

    public static class PriceContainer {

        private Lock lockObject = new ReentrantLock();
        private double bitCoinPrice;
        private double etherPrice;
        private double liteCoinPrice;
        private double bitCoinCashPrice;
        private double ripplePrice;

        public Lock getLockObject() {
            return lockObject;
        }

        public double getBitCoinPrice() {
            return bitCoinPrice;
        }

        public void setBitCoinPrice(double bitCoinPrice) {
            this.bitCoinPrice = bitCoinPrice;
        }

        public double getEtherPrice() {
            return etherPrice;
        }

        public void setEtherPrice(double etherPrice) {
            this.etherPrice = etherPrice;
        }

        public double getLiteCoinPrice() {
            return liteCoinPrice;
        }

        public void setLiteCoinPrice(double liteCoinPrice) {
            this.liteCoinPrice = liteCoinPrice;
        }

        public double getBitCoinCashPrice() {
            return bitCoinCashPrice;
        }

        public void setBitCoinCashPrice(double bitCoinCashPrice) {
            this.bitCoinCashPrice = bitCoinCashPrice;
        }

        public double getRipplePrice() {
            return ripplePrice;
        }

        public void setRipplePrice(double ripplePrice) {
            this.ripplePrice = ripplePrice;
        }

    }

    public static class PriceUpdater extends Thread {

        private final PriceContainer priceContainer;
        private final Random random = new Random();

        public PriceUpdater(PriceContainer priceContainer) {
            this.priceContainer = priceContainer;
        }

        @Override
        public void run() {
            while (true) {
                priceContainer.getLockObject().lock();
                try {
                    try {
//                        Thread.sleep(5000);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    priceContainer.setBitCoinPrice(random.nextInt(20000));
                    priceContainer.setEtherPrice(random.nextInt(2000));
                    priceContainer.setLiteCoinPrice(random.nextInt(500));
                    priceContainer.setBitCoinCashPrice(random.nextInt(5000));
                    priceContainer.setRipplePrice(random.nextDouble());
                } finally {
                    priceContainer.getLockObject().unlock();
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }

    }

    private void setLabel(Map<String, Label> cryptoLabels, PriceContainer pricesContainer) {
        Label bitcoinLabel = cryptoLabels.get("BTC");
        bitcoinLabel.setText(String.valueOf(pricesContainer.getBitCoinPrice()));

        Label etherLabel = cryptoLabels.get("ETH");
        etherLabel.setText(String.valueOf(pricesContainer.getEtherPrice()));

        Label litecoinLabel = cryptoLabels.get("LTC");
        litecoinLabel.setText(String.valueOf(pricesContainer.getLiteCoinPrice()));

        Label bitcoinCashLabel = cryptoLabels.get("BCH");
        bitcoinCashLabel.setText(String.valueOf(pricesContainer.getBitCoinCashPrice()));

        Label rippleLabel = cryptoLabels.get("XRP");
        rippleLabel.setText(String.valueOf(pricesContainer.getRipplePrice()));
    }

    private Rectangle chore(Stage primaryStage, GridPane grid, Map<String, Label> cryptoLabels) {
        SettingProperties.addLabelsToGrid(cryptoLabels, grid);

        double width = 300;
        double height = 250;

        StackPane root = new StackPane();

        Rectangle background = SettingProperties.createBackgroundRectangleWithAnimation(width, height);

        root.getChildren().add(background);
        root.getChildren().add(grid);

        primaryStage.setScene(new Scene(root, width, height));
        return background;
    }

}
