package choi.resursive;

/**
 * 팩토리얼
 * */
public class Problem03 {

    public static void main(String[] args) {
        Problem03 problem02 = new Problem03();
        int dfs = problem02.dfs(5);
        System.out.println(dfs);
    }

    public int dfs(int n) {
        if (n == 1) {
            return 1;
        }

        return n * dfs(n - 1);
    }

    // dfs(5) dfs(5)

}
