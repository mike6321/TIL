package com.example.java.multi_thread.lecture.section08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main02 {

    private static final int N = 10;
    private static final String INPUT_FILE = "./out/matrices";
    private static final String OUTPUT_FILE = "./out/matrices_result.txt";

    public static void main(String[] args) throws IOException {
        ThreadSafeQueue threadSafeQueue = new ThreadSafeQueue();

        File inputFile = new File(INPUT_FILE);
        File outputFile = new File(OUTPUT_FILE);

        MatricesReaderProducer matricesReader = new MatricesReaderProducer(new FileReader(inputFile), threadSafeQueue);
        MatricesMultiplierConsumer matricesConsumer = new MatricesMultiplierConsumer(threadSafeQueue, new FileWriter(outputFile));

        matricesConsumer.start();
        matricesReader.start();
    }

    private static class MatricesMultiplierConsumer extends Thread {
        private final ThreadSafeQueue queue;
        private final FileWriter fileWriter;

        private MatricesMultiplierConsumer(ThreadSafeQueue queue, FileWriter fileWriter) {
            this.queue = queue;
            this.fileWriter = fileWriter;
        }

        @Override
        public void run() {
            while (true) {
                MatricesPair matricesPair = queue.remove();
                if (matricesPair == null) {
                    System.out.println("No more matrices to read from the queue, consumer is terminating.");
                    break;
                }

                float[][] result = multiplyMatrices(matricesPair.matrix1, matricesPair.matrix2);

                try {
                    saveMatrixToFile(fileWriter, result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void saveMatrixToFile(FileWriter fileWriter, float[][] matrix) throws IOException {
            for (int r = 0; r < N; r++) {
                StringJoiner stringJoiner = new StringJoiner(", ");
                for (int c = 0; c < N; c++) {
                    stringJoiner.add(String.format("%.2f", matrix[r][c]));
                }
                fileWriter.write(stringJoiner.toString());
                fileWriter.write('\n');
            }
            fileWriter.write('\n');
        }

        private float[][] multiplyMatrices(float[][] m1, float[][] m2) {
            float[][] result = new float[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int k = 0; k < N; k++) {
                        result[r][c] += m1[r][k] * m2[k][c];
                    }
                }
            }
            return result;
        }

    }

    private static class MatricesReaderProducer extends Thread {
        private Scanner scanner;
        private ThreadSafeQueue queue;

        public MatricesReaderProducer(FileReader reader, ThreadSafeQueue queue) {
            this.scanner = new Scanner(reader);
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                float[][] matrix1 = readMatrix();
                float[][] matrix2 = readMatrix(); // 개행 다음 행렬

                if (matrix1 == null || matrix2 == null) {
                    queue.terminate();
                    System.out.println("No more matrices to read. Producer Thread is terminating.");
                    return;
                }

                MatricesPair matricesPair = new MatricesPair();
                matricesPair.matrix1 = matrix1;
                matricesPair.matrix2 = matrix2;

                queue.add(matricesPair);
            }
        }

        private float[][] readMatrix() {
            float[][] matrix = new float[N][N];
            for (int r = 0; r < N; r++) {
                if (!scanner.hasNext()) {
                    return null;
                }
                String[] line = scanner.nextLine().split(",");
                for (int c = 0; c < N; c++) {
                    matrix[r][c] = Float.valueOf(line[c]);
                }
            }
            scanner.nextLine();
            return matrix;
        }
    }

    private static class ThreadSafeQueue {
        private Queue<MatricesPair> queue = new LinkedList<>();
        private boolean isEmpty = true; // 큐에 행렬이 포함되어 있는지 확인
        private boolean isTerminate = false;

        // Producer 호출
        public synchronized void add(MatricesPair matricesPair) {
            queue.add(matricesPair);
            isEmpty = false;
            notify(); // Consumer 가 작업을 기다리는 경우 Consumer 를 깨우기 위함
        }

        // Consumer 호출
        // Consumer 가 행렬의 쌍을 소비한 이후 제거하기 위함
        public synchronized MatricesPair remove() {
            while (isEmpty && !isTerminate) { // 큐가 비었고 아직 읽을 데이터가 있을 때
                try {
                    wait(); // lock 을 release 하여 CPU 반환
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (queue.size() == 1) {
                isEmpty = true;
            }
            // 큐가 비었고 읽을 데이터가 없을 때
            if (queue.size() == 0 && isTerminate) {
                return null;
            }

            System.out.println("queue size : " + queue.size());

            return queue.remove();
        }

        // Producer 호출
        // Producer 가 더이상 읽을 데이터가 없을 때
        // 큐가 비면 Consumer 가 스레드를 종료해야함을 알리기 위함
        public synchronized void terminate() {
            isTerminate = true;
            notifyAll();
        }

    }

    private static class MatricesPair {
        public float[][] matrix1;
        public float[][] matrix2;
    }

}
