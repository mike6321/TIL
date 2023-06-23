package choi.efficiency;

import java.util.Scanner;

/**
 * 최대 매출
 * https://cote.inflearn.com/contest/10/problem/03-03
 *
10 3
12 15 11 20 25 10 20 19 13 15
 * */
public class MaximumSales_Efficiency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            if (i < m) {
                sum += array[i];
            }
        }

        int result = sum;
        for (int i = m; i < n; i++) {
            sum += array[i] - array[i-m];
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }

}
