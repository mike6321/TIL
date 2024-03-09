package choi.redaytolivecoding.cote;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test02 {

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        // true
//        int n = 3;
//        int[] a = new int[]{1,3};
//        int[] b = new int[]{2,2};

        // false
//        int n = 6;
//        int[] a = new int[]{2,4,5,3};
//        int[] b = new int[]{3,5,6,4};

        // true
//        int n = 4;
//        int[] a = new int[]{1,2,4,4,3};
//        int[] b = new int[]{2,3,1,3,1};

        // false
//        int n = 4;
//        int[] a = new int[]{1,2,1,3};
//        int[] b = new int[]{2,4,3,4};

        // true
        int n = 3;
        int[] a = new int[]{1,3};
        int[] b = new int[]{2,2};
        boolean solution = test02.solution(n, a, b);
        System.out.println(solution);
    }

    public boolean solution(int N, int[] A, int[] B) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            graph.putIfAbsent(A[i], new HashSet<>());
            graph.putIfAbsent(B[i], new HashSet<>());
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }

        // 오름차순으로 연결된 간선 확인
        for (int i = 1; i < N; i++) {
            if (!graph.containsKey(i) || !graph.get(i).contains(i + 1)) {
                return false;
            }
        }

        // 마지막 노드가 이전 노드와 연결되어 있는지 확인
        if (!graph.containsKey(N) || !graph.get(N).contains(N - 1)) {
            return false;
        }

        return true;
    }

//    private void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int current) {
//        visited[current] = true;
//        if (graph.containsKey(current)) {
//            for (int next : graph.get(current)) {
//                if (!visited[next]) {
//                    dfs(graph, visited, next);
//                }
//            }
//        }
//    }

}
