package choi.resursive;

/**
 * 이진수 출력
 * */
public class Problem02 {

    public static void main(String[] args) {
        Problem02 problem02 = new Problem02();
        problem02.dfs(11);
    }

    public void dfs(int n) {
        if (n == 0) {
            return;
        }

        dfs(n / 2);
        System.out.print(n % 2 + " ");
    }

}
