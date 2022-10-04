package com.example.java.multi_thread.lecture.section02;

public class Main03 {

    public static void main(String[] args) {
        Thread thread = new NewThread();
        thread.setName("New Thread");
        thread.start();
    }

    private static class NewThread extends Thread {
        @Override
        public void run() {
//            System.out.println("Hello from " + Thread.currentThread().getName());
            System.out.println("Hello from " + this.getName());
        }
    }

}
