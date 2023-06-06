package choi.array;

import java.util.Scanner;

/**
 * 임시반장 정하기
 * https://cote.inflearn.com/contest/10/problem/02-11
 *
5
2 3 1 7 3
4 1 9 6 8
5 5 2 4 4
6 5 2 6 7
8 4 2 2 2
 * */
public class InterimLeader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n+1][6];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                array[i][j] = scanner.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (array[j][k] == array[i][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                result = i;
            }
        }

        System.out.print(result);

    }

}
