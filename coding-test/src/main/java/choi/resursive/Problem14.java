package choi.resursive;

import java.util.*;

/**
 * 그래프 최단거리 (BFS)
6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
 * */
public class Problem14 {

    private static int n;
    private static int m;
    private static int[] check;
    private static int[] distance;
    private static List<List<Integer>> graph;

    public static void main(String[] args) {
        Problem14 problem = new Problem14();
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        graph = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            graph.add(new ArrayList<>());
        }

        check = new int[n+1];
        distance = new int[n+1];

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph.get(a).add(b);
        }

        problem.bfs(1);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + distance[i]);
        }
    }

    private void bfs(int i) {
        Queue<Integer> queue = new LinkedList<>();
        check[i] = 1;
        distance[i] = 0;

        queue.add(i);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int nv : graph.get(current)) {
                if (check[nv] == 0) {
                    check[nv] = 1;
                    queue.offer(nv);
                    distance[nv] = distance[current] + 1;
                }
            }
        }
    }

}
