package choi.resursive;

/**
 * 피보나치 수열 (dfs-메모이제이션)
 * 이미 계산된 값 재활용
 * */
public class Problem04_4 {

    private static int[] fibo;

    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n+1]; // 0번 index 는 필요없다.
        Problem04_4 problem = new Problem04_4();
        problem.recursiveSolution03(n);
    }

    private void recursiveSolution03(int n) {
        dfs(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(dfs(i) + " ");
        }
    }

    public int dfs(int n) {
        // 이미 계산된 값 재활용
        if (fibo[n] != 0) {
            return fibo[n];
        }
        if (n == 1 || n == 2) {
            fibo[n] = 1;
            return fibo[n];
        }

        fibo[n] = dfs(n-1) + dfs(n-2);
        return fibo[n];
    }

}
