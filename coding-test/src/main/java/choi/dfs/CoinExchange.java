package choi.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class CoinExchange {

    private static int result = Integer.MAX_VALUE;
    private static int n;
    private static Integer[] array;
    private static int change;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        Arrays.sort(array, Collections.reverseOrder());


        change = scanner.nextInt();

        CoinExchange coinExchange = new CoinExchange();
        coinExchange.dfs(0, 0);

        System.out.println(result);
    }

    private void dfs(int level, int sum) {
        if (level > result) {
            return;
        }
        if (sum > change) {
            return;
        }
        if (sum == change) {
            result = Math.min(level, result);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(level+1, sum + array[i]);
            }
        }
    }

}
