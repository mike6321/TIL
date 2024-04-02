package choi.redaytolivecoding.bfs_dfs;

public class b_이진수출력 {

    public static void main(String[] args) {
        b_이진수출력 t = new b_이진수출력();
        t.dfs(11);
    }

    /**
     * d(0) return
     * d(1) - line 19 -> 1
     * d(2) - line 19 -> 0
     * d(5) - line 19 -> 1
     * d(11) - line 19 -> 1
     *
     * 재귀 호출 전 출력하면 거꾸로
     * */
    public void dfs(int n) {
        if (n == 0) {
            return;
        }

//        System.out.println(n % 2);
        dfs(n / 2);
        System.out.println(n % 2);
    }

}
