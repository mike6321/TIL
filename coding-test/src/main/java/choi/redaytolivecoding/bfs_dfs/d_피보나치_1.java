package choi.redaytolivecoding.bfs_dfs;

public class d_피보나치_1 {

    public static void main(String[] args) {
        d_피보나치_1 t = new d_피보나치_1();
        int dfs = t.dfs(5);
        System.out.println(dfs);
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
