package com.example.webflux;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class BlockingServerExample {

    public static final Logger log = LoggerFactory.getLogger(BlockingServerExample.class.getName());

    public static void main(String[] args) {
        int port = 8080;
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            log.info("Started server and port : {}", port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                log.info("Connected Client: {}", clientSocket.getInetAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String readLine = reader.readLine();
                log.info("Received Message: {}", readLine);

                clientSocket.close();
                log.info("Closed Client: {}", clientSocket.getInetAddress());
            }

        } catch (IOException e) {
            log.error("Could not start server", e);
        }
    }

}
