package choi.array;

import java.util.Scanner;

/**
 * 점수 계산
 * https://cote.inflearn.com/contest/10/problem/02-07
 *
10
1 0 1 1 1 0 0 1 1 0
 * */
public class CalculatingScore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] check = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                check[i] = arr[i];
            }
            if (i-1 < 0) {
                continue;
            }
            if (arr[i-1] > 0 && arr[i] == 1) {
                check[i] = check[i-1] + arr[i];
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += check[i];
        }

        System.out.println(result);
    }

}
