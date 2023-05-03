package choi.resursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
public class Problem13 {

    private static int[] check;
    private static List<List<Integer>> graph;
    private static int n = 0;
    private static int m = 0;
    private static int answer = 0;

    public static void main(String[] args) {
        Problem13 problem = new Problem13();
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        check = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        check[1] = 1;
        problem.dfs(1);
        System.out.println(answer);
    }

    public void dfs(int v) {
        if (v == n) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (check[nv] == 0) {
                    check[nv] = 1;
                    dfs(nv);
                    check[nv] = 0;
                }
            }
        }
    }

}
