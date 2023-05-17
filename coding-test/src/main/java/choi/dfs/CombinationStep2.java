package choi.dfs;

import java.util.Scanner;

/**
 * 조합의 경우의수
 * https://cote.inflearn.com/contest/10/problem/08-07
 *
 5 3
 33 19
 * */
public class CombinationStep2 {

    private static int n;
    private static int m;
    private static int[] array;
    private static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        array = new int[m];

        CombinationStep2 combinationStepTwo = new CombinationStep2();
        combinationStepTwo.dfs(0, 1);

        System.out.println(result);
    }

    private void dfs(int level, int index) {
        if (level == m) {
            result++;
        } else {
            for (int i = index; i <= n; i++) {
                array[level] = i;
                dfs(level+1, i+1);
            }
        }
    }

}
