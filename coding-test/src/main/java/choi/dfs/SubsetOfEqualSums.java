package choi.dfs;

import java.util.Scanner;

/**
 * 합이 같은 부분집합
 * https://cote.inflearn.com/contest/10/problem/08-01
 * */
public class SubsetOfEqualSums {

    private static int n;
    private static int[] array;
    private static boolean flag;
    private static int total;
    private static String result = "NO";

    public static void main(String[] args) {
        SubsetOfEqualSums problem = new SubsetOfEqualSums();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            total += array[i];
        }

        problem.dfs(0, 0);

        System.out.println(result);
    }

    private void dfs(int level, int sum) {
        if (flag || sum > total / 2) {
            return;
        }
        if (level == n) {
            if ((total - sum) == sum) {
                result = "YES";
                flag = true;
            }
        } else {
            dfs(level+1, sum + array[level]);
            dfs(level+1, sum);
        }
    }

}
