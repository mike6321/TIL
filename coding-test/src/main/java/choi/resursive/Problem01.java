package choi.resursive;

public class Problem01 {

    public static void main(String[] args) {
        Problem01 problem01 = new Problem01();
        problem01.dfs(3);
    }

    public void dfs(int n) {
        if (n == 0) {
            return;
        }

        dfs(n-1);
        System.out.println(n);
    }

}
