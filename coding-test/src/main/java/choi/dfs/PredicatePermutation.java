package choi.dfs;

import java.util.Scanner;

/**
 * 수열 추측하기
 * https://cote.inflearn.com/contest/10/problem/08-08
 *
4 16
 * */
public class PredicatePermutation {

    private static int n;
    private static int bottomNumber;
    private static int[] permutation;
    private static int[] check;
    private static int[] targetArray;
    private int[][] dy = new int[35][35];
    private boolean flag;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        bottomNumber = scanner.nextInt();
        permutation = new int[n];
        check = new int[n];
        targetArray = new int[n];

        PredicatePermutation predicatePermutation = new PredicatePermutation();
        for (int i = 0; i < n; i++) {
            targetArray[i] = predicatePermutation.combination(n-1, i);
        }


        predicatePermutation.dfs(0, 0);
    }

    private int combination(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            dy[n][r] = combination(n-1, r-1) + combination(n-1, r);
            return dy[n][r];
        }
    }

    private void dfs(int level, int sum) {
        if (flag) {
            return;
        }
        if (level == n) {
            if (sum == bottomNumber) {
                for (int i : permutation) {
                    System.out.print(i + " ");
                }
                System.out.println();
                flag = true;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    permutation[level] = i + 1;
                    dfs(level + 1, sum + (permutation[level] * targetArray[level]));
                    check[i] = 0;
                }
            }
        }
    }

}
