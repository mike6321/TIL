package choi.dfs;

import java.util.Scanner;

/**
 * 순열
3 2
3 6 9
 * */
public class Permutation {

    private static int n;
    private static int m;
    private static int[] array;
    private static int[] check;
    private static int[] permutationArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt(); // 몇개 뽑을지

        array = new int[n];
        check = new int[n];
        permutationArray = new int[m];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Permutation permutation = new Permutation();
        permutation.dfs(0);
    }

    private void dfs(int level) {
        if (m == level) {
            for (int i : permutationArray) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    permutationArray[level] = array[i];
                    dfs(level + 1);
                    check[i] = 0;
                }
            }
        }
    }

}
