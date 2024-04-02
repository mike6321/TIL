package choi.redaytolivecoding.bfs_dfs;

// 1 1 2 3 5
public class d_피보나치_2 {

    public static void main(String[] args) {
        d_피보나치_2 t = new d_피보나치_2();
        int n = 5;
        for (int i = 1; i <= n; i++) {
            System.out.println(t.dfs(i));
        }
    }

    public int dfs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return dfs(n - 2) + dfs(n - 1);
        }
    }

}
