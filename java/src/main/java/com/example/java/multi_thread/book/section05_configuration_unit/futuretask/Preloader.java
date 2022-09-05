package com.example.java.multi_thread.book.section05_configuration_unit.futuretask;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class Preloader {

    // long time-consuming work
    ProductInfo loadProductInfo() {
        log.info("loadProductInfo");
        return null;
    }

    private final FutureTask<ProductInfo> future = new FutureTask<>(() -> loadProductInfo());

    private final Thread thread = new Thread(future);

    public void start() {
        thread.start();
    }

    public ProductInfo get() throws DataLoadException, InterruptedException {
        try {
            log.info("future.get");
            return future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataLoadException) {
                throw (DataLoadException) cause;
            } else {
                throw LaunderThrowable.launderThrowable(cause);
            }
        }
    }

    interface ProductInfo {
    }

    public static void main(String[] args) throws InterruptedException, DataLoadException {
        Preloader preloader = new Preloader();
        preloader.start();
        preloader.get();
    }

}

class DataLoadException extends Exception { }
