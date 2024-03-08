package choi.redaytolivecoding.string;

import java.util.Scanner;

public class g_PalindromeString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        char[] charArray = str.toCharArray();
        int lt = 0;
        int rt = charArray.length - 1;

        String result = "YES";
        while (lt < rt) {
            if (charArray[lt] == charArray[rt]) {
                lt++;
                rt--;
                continue;
            }

            result = "NO";
            break;
        }

        System.out.println(result);

    }

}
