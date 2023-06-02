package choi.array;

import java.util.Scanner;

public class MaximumSumOfLatticePlates {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        int diagonal1 = 0;
        int diagonal2 = 0;
        int result = Integer.MIN_VALUE;

        init(scanner, n, arr);

        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    diagonal1 += arr[i][j];
                }
                if ((i+j) == n+1) {
                    diagonal2 += arr[i][j];
                }
                rowSum += arr[i][j];
                columnSum += arr[j][i];
            }

            result = Math.max(result, diagonal1);
            result = Math.max(result, diagonal2);
            result = Math.max(result, rowSum);
            result = Math.max(result, columnSum);
        }
        System.out.println(result);
    }

    private static void init(Scanner scanner, int n, int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
    }

}
