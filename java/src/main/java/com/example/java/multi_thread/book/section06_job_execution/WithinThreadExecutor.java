package com.example.java.multi_thread.book.section06_job_execution;

import java.util.concurrent.Executor;

public class WithinThreadExecutor implements Executor {

    // 순차적으로 처리
    @Override
    public void execute(Runnable command) {
        command.run();
    }

}
