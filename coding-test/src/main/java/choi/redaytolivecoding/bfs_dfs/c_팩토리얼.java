package choi.redaytolivecoding.bfs_dfs;

public class c_팩토리얼 {

    public static void main(String[] args) {
        c_팩토리얼 t = new c_팩토리얼();
        int dfs = t.dfs(5);
        System.out.println(dfs);
    }

    /**
     * d(1) -> return 1
     * d(2) -> 2 * d(1)
     * d(3) -> 3 * d(2)
     * d(4) -> 4 * d(3)
     * d(5) -> 5 * d(4)
     * */
    public int dfs(int n) {
        if (n == 1) {
            return 1;
        }

        return n * dfs(n -1);
    }

}
