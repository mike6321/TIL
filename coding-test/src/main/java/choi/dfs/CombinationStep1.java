package choi.dfs;

import java.util.Scanner;

/**
 * 조합의 경우의수
 * https://cote.inflearn.com/contest/10/problem/08-07
 *
 5 3
 33 19
 * */
public class CombinationStep1 {

    private static int n;
    private static int m;
    private static int[] array;
    private static int[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        check = new int[n];
        array = new int[m];

        CombinationStep1 combination = new CombinationStep1();
        combination.dfs(0);
    }

    private void dfs(int level) {
        if (m == level) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (check[i-1] == 0) {
                    check[i-1] = 1;
                    array[level] = i;
                    dfs(level + 1);
                    check[i-1] = 0;
                }
            }
        }
    }

}
