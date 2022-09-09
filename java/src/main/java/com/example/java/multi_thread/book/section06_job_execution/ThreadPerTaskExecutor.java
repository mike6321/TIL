package com.example.java.multi_thread.book.section06_job_execution;

import java.util.concurrent.Executor;

public class ThreadPerTaskExecutor implements Executor {

    // 작업마다 스레드 생성
    @Override
    public void execute(Runnable command) {
        new Thread(command).start();
    }

}
