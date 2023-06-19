package choi.efficiency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 공통원소 구하기
 * https://cote.inflearn.com/contest/10/problem/03-02
 *
5
1 3 9 5 2
5
3 2 5 7 8
 * */
public class CommonElements {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = scanner.nextInt();
        }
        Arrays.sort(array1);

        int m = scanner.nextInt();
        int[] array2 = new int[m];
        for (int i = 0; i < m; i++) {
            array2[i] = scanner.nextInt();
        }
        Arrays.sort(array2);


        int p1 = 0;
        int p2 = 0;
        List<Integer> result = new ArrayList<>();
        while (p1 < n && p2 < m) {
            if (array1[p1] == array2[p2]) {
                result.add(array1[p1]);
                p1++;
                p2++;
            } else if (array1[p1] < array2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
    }

}
