package choi.resursive;

/**
 * 피보나치 수열 (dfs-배열저장)
 * */
public class Problem04_3 {

    private static int[] fibo;

    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n+1]; // 0번 index 는 필요없다.
        Problem04_3 problem = new Problem04_3();
        problem.recursiveSolution02(n);
    }

    private void recursiveSolution02(int n) {
        dfs(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(dfs(i) + " ");
        }
    }

    public int dfs(int n) {
        if (n == 1 || n == 2) {
            fibo[n] = 1;
            return fibo[n];
        }

        fibo[n] = dfs(n-1) + dfs(n-2);
        return fibo[n];
    }

}
