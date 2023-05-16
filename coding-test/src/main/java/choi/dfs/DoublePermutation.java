package choi.dfs;

import java.util.Scanner;

/**
 * 중복순열
 * https://github.com/mike6321/TIL/assets/33277588/07ab9453-a295-4dfc-98ff-3ce5724d8851
 *
 * 3 2
 * */
public class DoublePermutation {

    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt(); // 몇개 뽑을지

        int[] array = new int[m];

        DoublePermutation doublePermutation = new DoublePermutation();
        doublePermutation.dfs(0, array);
    }

    private void dfs(int level, int[] array) {
        if (level == m) {
            for (int result : array) {
                System.out.print(result + " ");
            }
            System.out.println();
        } else {
            for (int i =1 ; i <= n; i++) {
                array[level] = i;
                dfs(level+1, array);
            }
        }
    }

}
