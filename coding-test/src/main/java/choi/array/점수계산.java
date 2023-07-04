package choi.array;

import java.util.Scanner;

/**
 * 점수 계산
 * https://cote.inflearn.com/contest/10/problem/02-07
 *
10
1 0 1 1 1 0 0 1 1 0
 * */
public class 점수계산 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                cnt++;
                result += cnt;
            } else {
                cnt = 0;
            }
        }

        System.out.println(result);
    }

}
