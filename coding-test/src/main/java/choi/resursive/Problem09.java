package choi.resursive;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/07-08
 * */
public class Problem09 {

    private final static int[] dis = {1, -1, 5};
    private final static int[] check = new int[10001];
    private final static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int e = in.nextInt();

        int result = bfs(s, e);
        System.out.print(result);
    }

    private static int bfs(int s, int e) {
        check[s] = 1;
        queue.add(s);

        int level = 0;

        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                int x = queue.poll();
                for (int j = 0; j < dis.length; j++) {
                    int nx = x + dis[j];
                    if (nx == e) {
                        return level + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && check[nx] == 0) {
                        check[nx] = 1;
                        queue.add(nx);
                    }
                }
            }
            level++;
        }
        return 0;
    }

}
