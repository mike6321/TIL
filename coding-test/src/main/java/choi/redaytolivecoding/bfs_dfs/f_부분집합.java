package choi.redaytolivecoding.bfs_dfs;

/**
 * 3
 *
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 * */
public class f_부분집합 {

    private static int n;
    private static int[] ch;

    public static void main(String[] args) {
        f_부분집합 test = new f_부분집합();
        n = 3;
        ch = new int[n+1];
        test.dfs(1);
        System.out.println();
    }

    public void dfs(int level) {
        if (level == n + 1) {
            String temp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    temp += i + " ";
                }
            }

            if (!temp.isEmpty()) {
                System.out.println(temp);
            }

            return;

        }

        ch[level] = 1;
        dfs(level + 1); // left (사용 o)
        ch[level] = 0;
        dfs(level + 1); // right (사용 x)
    }

}
