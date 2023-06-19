package choi.efficiency;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 두 배열 합치기
 *
 * https://cote.inflearn.com/contest/10/problem/03-01
3
1 3 5
5
2 3 6 7 9
 * */
public class DoubleArrangementCombinations_TwoPointer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] array2 = new int[m];
        for (int i = 0; i < m; i++) {
            array2[i] = scanner.nextInt();
        }

        int p1 = 0;
        int p2 = 0;
        List<Integer> result = new ArrayList<>();
        while (p1 < n && p2 < m) {
            if (array1[p1] < array2[p2]) {
                result.add(array1[p1++]);
                continue;
            }

            result.add(array2[p2++]);
        }

        while (p1 < n) {
            result.add(array1[p1++]);
        }
        while (p2 < m) {
            result.add(array2[p2++]);
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }

    }

}
