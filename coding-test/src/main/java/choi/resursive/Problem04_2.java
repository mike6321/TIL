package choi.resursive;

/**
 * 피보나치 수열 (dfs)
 * */
public class Problem04_2 {

    public static void main(String[] args) {
        int n = 10;
        Problem04_2 problem = new Problem04_2();
        problem.recursiveSolution01(n);
    }

    private void recursiveSolution01(int n) {
        dfs(n);

        for (int i = 1; i <= n; i++) {
            System.out.print(dfs(i) + " ");
        }
    }

    public int dfs(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        return dfs(n-1) + dfs(n-2);
    }

}
