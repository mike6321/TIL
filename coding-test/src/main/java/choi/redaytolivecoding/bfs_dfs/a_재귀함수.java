package choi.redaytolivecoding.bfs_dfs;

public class a_재귀함수 {

    public static void main(String[] args) {
        a_재귀함수 t = new a_재귀함수();
        t.dfs(3);
    }

    /**
     * d(0) return
     * d(1) - line21
     * d(2) - line21
     * d(3) - line21
     *
     * 1
     * d(2) - line21
     * d(3) - line21
     *
     * 1
     * 2
     * d(3) - line21
     * */
    public void dfs(int n) {
        if (n == 0) {
            return;
        }
        // 3 2 1
//        System.out.println(n);
        dfs(n-1);
        // 1 2 3
        System.out.println(n);
    }

}
