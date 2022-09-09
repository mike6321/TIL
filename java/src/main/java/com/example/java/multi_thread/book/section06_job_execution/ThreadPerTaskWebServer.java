package com.example.java.multi_thread.book.section06_job_execution;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadPerTaskWebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            final Socket connection = socket.accept();
            Runnable task = () -> handleRequest(connection);
            new Thread(task).start(); // 작업마다 스레드 생성
        }
    }

    private static void handleRequest(Socket connection) {
        // request handling logic here
    }

}
