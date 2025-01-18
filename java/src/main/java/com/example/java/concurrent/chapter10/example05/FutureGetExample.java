package com.example.java.concurrent.chapter10.example05;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class FutureGetExample {

    /**
     * @see java.util.concurrent.AbstractExecutorService#submit(Callable)
     * @see java.util.concurrent.FutureTask#FutureTask(Callable)
     * @see java.util.concurrent.ThreadPoolExecutor#execute(Runnable)
     * @see java.util.concurrent.ThreadPoolExecutor#runWorker(ThreadPoolExecutor.Worker)
     * @see java.util.concurrent.FutureTask#run()
     * @see java.util.concurrent.FutureTask#set(Object)
     *
     * @see java.util.concurrent.FutureTask#NEW
     * @see java.util.concurrent.FutureTask#COMPLETING
     * @see java.util.concurrent.FutureTask#NORMAL
     * @see java.util.concurrent.FutureTask#EXCEPTIONAL
     * @see java.util.concurrent.FutureTask#CANCELLED
     * @see java.util.concurrent.FutureTask#INTERRUPTING
     * @see java.util.concurrent.FutureTask#INTERRUPTED
     * */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<Integer> callableTask = () -> {
            log.info("비동기 작업 요청 후 메인 스레드 작업 수행 중...");
            Thread.sleep(2000);
            return 40;
        };

        Future<Integer> future = executorService.submit(callableTask);

        while (!future.isDone()) {
            log.info("비동기 작업이 완료되지 않았습니다.");
            Thread.sleep(500);
        }

        Integer result = future.get();
        log.info("비동기 작업 결과: {}", result);

        executorService.shutdown();
    }

}
