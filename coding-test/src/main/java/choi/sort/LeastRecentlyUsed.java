package choi.sort;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/06-04
 * */
public class LeastRecentlyUsed {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cacheSize = in.nextInt();
        int loopNum = in.nextInt();
        int[] cache = new int[cacheSize];

        for (int i = 0; i < loopNum; i++) {
            int targetNum = in.nextInt();
            int j;
            boolean hit = false;
            for (j = 0; j < cacheSize; j++) {
                // cache hit
                if (cache[j] == targetNum) {
                    hit = true;
                    break;
                }
            }

            if (hit) {
                int temp = cache[j];
                for (int k = j; k > 0; k--) {
                    cache[k] = cache[k-1];
                }

                cache[0] = temp;
            } else {
                for (int k = j-1; k > 0; k--) {
                    cache[k] = cache[k-1];
                }
                cache[0] = targetNum;
            }

        }

        for (int i : cache) {
            System.out.print(i + " ");
        }

    }

}
