package choi.redaytolivecoding.array;

import java.util.Scanner;

public class i_격자판최대합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] array = new int[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        /**
         * point : 행, 열 대각선
         * */
        // 행, 열
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < num; i++) {
            int sum1 = 0;
            int sum2 = 0;
            for (int j = 0; j < num; j++) {
                sum1 += array[i][j];
                sum2 += array[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        // 대각선
        for (int i = 0; i < num; i++) {
            int sum1 = array[i][i];
            int sum2 = array[i][num - 1 - i];
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }

        System.out.println(answer);


    }
}
