package choi.go;

public class Problem03 {

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int k = 3;

        int[][] acts = {{1, 1, 2}, {1, 2, 3}, {2, 4, 2}};

        Problem03 problem03 = new Problem03();
        long[] solution = problem03.solution(n, m, k, acts);
        for (long l : solution) {
            System.out.print(l + " ");
        }
    }

    public long[] solution(int n, int m, int k, int[][] acts) {
        long[] answer = {};

        int[][] array = new int[n][m];
        for (int i = 0; i < acts.length; i++) {
            int type = acts[i][0];
            int x = acts[i][1] - 1;
            int p = acts[i][2];

            if (type == 1) {
                for (int t = 0; t < m; t++) {
                    array[x][t] = p;
                }
            } else {
                for (int t = 0; t < n; t++) {
                    array[t][x] = p;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j]);
            }
        }


        return answer;
    }

}
