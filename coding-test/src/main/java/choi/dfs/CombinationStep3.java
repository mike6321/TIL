package choi.dfs;

import java.util.Scanner;

/**
 * 조합의 경우의수
 * https://cote.inflearn.com/contest/10/problem/08-07
 *
 5 3
 33 19
 * */
public class CombinationStep3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();

        CombinationStep3 combinationStep3 = new CombinationStep3();
        System.out.println(combinationStep3.dfs(n, r));
    }

    private int dfs(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else {
            return dfs(n-1, r-1) + dfs(n-1, r);
        }
    }

}
