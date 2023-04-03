package choi.array;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-02
 * */
public class VisibleStudent {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int result = 1;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                result++;
                max = arr[i];
            }
        }

        System.out.println(result);
    }

}
