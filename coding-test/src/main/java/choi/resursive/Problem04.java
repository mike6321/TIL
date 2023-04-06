package choi.resursive;

/**
 * 피보나찌
 * */
public class Problem04 {

    public static void main(String[] args) {
        Problem04 problem04 = new Problem04();
        int n = 45;
        int[] fibo =  new int[n+1];
        problem04.dfs(n, fibo);

        for (int i = 1; i < n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public int dfs(int n, int[] fibo) {
        if (fibo[n] != 0) {
            return fibo[n];
        }
        if (n == 1) {
            fibo[n] = 1;
            return 1;
        }
        if (n == 2) {
            fibo[n] = 1;
            return 1;
        }

        return fibo[n] = dfs(n - 1, fibo) + dfs(n - 2, fibo);
    }

}
