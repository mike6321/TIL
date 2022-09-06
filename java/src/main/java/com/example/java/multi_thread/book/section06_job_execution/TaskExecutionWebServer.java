package com.example.java.multi_thread.book.section06_job_execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutionWebServer {

    private static final int N_THREAD = 100;
    private static final Executor executor = Executors.newFixedThreadPool(N_THREAD);

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection); // 요청을 처리 (Consumer)
            executor.execute(task); // 요청을 등록 (Producer)
        }
    }

    private static void handleRequest(Socket connection) {
        // request handling logic here
    }

}
