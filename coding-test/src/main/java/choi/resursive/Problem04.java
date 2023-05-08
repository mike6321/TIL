package choi.resursive;

/**
 * 피보나치 수열 (array, 재귀)
 * https://user-images.githubusercontent.com/33277588/236823729-438df6c3-cea6-448a-9cc7-1955750c3064.png
 * */
public class Problem04 {

    public static void main(String[] args) {
        int n = 10;
        Problem04 problem = new Problem04();
        problem.recursiveSolution02(n);
    }


    private void recursiveSolution02(int n) {
        int[] fibo =  new int[n+1];
        dfs(n, fibo);

        for (int i = 1; i < n+1; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    public int dfs(int n, int[] fibo) {
        if (fibo[n] != 0) {
            return fibo[n];
        }
        if (n == 1 || n == 2) {
            fibo[n] = 1;
            return 1;
        }

        return fibo[n] = dfs(n - 1, fibo) + dfs(n - 2, fibo);
    }

}
