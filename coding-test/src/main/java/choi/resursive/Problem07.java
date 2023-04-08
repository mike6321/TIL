package choi.resursive;

import java.util.Scanner;

public class Problem07 {

    private static int last;
    private static int[] checkArray;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        last = in.nextInt();
        checkArray = new int[last + 1];

        Problem07 problem07 = new Problem07();
        problem07.dfs(1);
    }

    public void dfs(int num) {
        if (num == last + 1) {
            String temp = "";
            for (int i = 1; i <= last; i++) {
                if (checkArray[i] == 1) {
                    temp += (i + " ");
                }
            }
            if (temp.length() > 0) {
                System.out.println(temp);
            }
        } else {
            checkArray[num] = 1;
            dfs(num + 1);
            checkArray[num] = 0;
            dfs(num + 1);
        }
    }


}
