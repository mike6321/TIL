package com.example.kafka.references.consumer.request;

import java.nio.charset.StandardCharsets;

public class ByteConverter {

    public static void main(String[] args) {
        byte[] data = {0, 1, 0, 0, 0, 0, -1, -1, -1, -1};
        String value = new String(data, StandardCharsets.UTF_8);

        System.out.println(value);

        String str = "Hello, World!";
        byte[] bytes = str.getBytes();
        System.out.println(bytes);

    }
}
