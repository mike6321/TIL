package choi.redaytolivecoding.bfs_dfs;

// 1 1 2 3 5
public class d_피보나치_4 {

    static int[] fibo;
    public static void main(String[] args) {
        d_피보나치_4 t = new d_피보나치_4();
        int n = 45;
        fibo = new int[n+1];

        t.dfs(n);


        for (int i = 1; i <= n; i++) {
            System.out.println(fibo[i]);
        }
    }

    public int dfs(int n) {
        // 메모이제이션
        if (fibo[n] > 0) {
            return fibo[n];
        }

        if (n == 1) {
            fibo[n] = 1;
        } else if (n == 2) {
            fibo[n] = 1;
        } else {
            fibo[n] = dfs(n - 2) + dfs(n - 1);
        }
        return fibo[n];
    }

}
