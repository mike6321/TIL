package choi.dfs;

import java.util.Scanner;

/**
 * 조합의 경우의수 (메모이제이션)
 * https://cote.inflearn.com/contest/10/problem/08-07
 *
5 3
33 19
 * */
public class CombinationStep4 {

    int[][] dy = new int[35][35];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        CombinationStep4 combinationStep3 = new CombinationStep4();
        System.out.println(combinationStep3.dfs(n, r));
    }

    private int dfs(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            dy[n][r] = dfs(n-1, r-1) + dfs(n-1, r);
            return dy[n][r];
        }
    }

}
