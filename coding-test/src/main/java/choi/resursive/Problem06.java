package choi.resursive;

/**
 * 부분집합
 * https://github.com/mike6321/TIL/assets/33277588/5e2bab1f-aa95-4dd9-87da-2500fa90ba63
 * */
public class Problem06 {

    private static int n;
    private static int[] check;

    public static void main(String[] args) {
        Problem06 problem = new Problem06();
        n = 3;
        check = new int[n+1];
        problem.dfs(1);
    }

    public void dfs(int level) {
        if (level == n + 1) {
            StringBuilder temp = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (check[i] == 1) {
                    temp.append(i).append(" ");
                }
            }
            if (temp.length() > 0) {
                System.out.println(temp);
            }
        } else {
            check[level] = 1;
            dfs(level+1);
            check[level] = 0;
            dfs(level+1);
        }
    }

}
