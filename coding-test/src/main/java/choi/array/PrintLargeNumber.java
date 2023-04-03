package choi.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/02-01
 * */
public class PrintLargeNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        List<Integer> result = new ArrayList<>();
        result.add(arr[0]);
        for (int i = 0; i < n-1; i++) {
            if (arr[i] < arr[i+1]) {
                result.add(arr[i+1]);
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

}
