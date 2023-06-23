package choi.efficiency;

import java.util.Scanner;

/**
 * 최대 매출
 * https://cote.inflearn.com/contest/10/problem/03-03
 *
10 3
12 15 11 20 25 10 20 19 13 15
 * */
public class MaximumSales {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int k = 0; k < m; k++) {
                sum += array[i+k];
            }
            result = Math.max(result, sum);
            if (i+3 > n-1) {
                break;
            }
        }
        System.out.println(result);
    }

}
