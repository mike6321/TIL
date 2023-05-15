package choi.dfs;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/08-02

259 5
81
58
42
33
61
 * */
public class Baduk {

    private static int c;
    private static int n;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c = scanner.nextInt();
        n = scanner.nextInt();

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Baduk baduk = new Baduk();
        baduk.dfs(0, 0, array);

        System.out.println(answer);
    }

    private void dfs(int level, int sum, int[] array) {
        if (sum > c) {
            return;
        }

        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(level+1, sum + array[level], array); // o
            dfs(level+1, sum, array); // x
        }

    }

}
