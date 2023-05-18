package choi.dfs;

import java.util.Scanner;

public class Combination {

    private static int n;
    private static int m;
    private static int[] array;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        array = new int[m];

        Combination combination = new Combination();
        combination.dfs(0, 1);
    }

    public void dfs(int level, int index) {
        if (level == m) {
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = index; i <= n; i++) {
                array[level] = i;
                dfs(level + 1, i + 1);
            }
        }
    }

}
