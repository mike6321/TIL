package choi.resursive;

import java.util.Scanner;

/**
 * 경로탐색 (DFS)
 * */
//5 9
//1 2
//1 3
//1 4
//2 1
//2 3
//2 5
//3 4
//4 2
//4 5


public class Problem12 {

    private static int[][] graph;
    private static int[] check;
    private static int n = 0;
    private static int m = 0;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new int[n+1][n+1];
        check = new int[n+1];

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph[x][y] = 1;
        }

        check[1] = 1;
        Problem12 problem12 = new Problem12();
        problem12.dfs(1);

        System.out.println(answer);
    }
    
    public void dfs(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    dfs(i);
                    check[i] = 0;
                }
            }
        }
    }

}
