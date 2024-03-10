package choi.redaytolivecoding.string;

import java.util.Scanner;

public class g_회문문자열_RE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine().toLowerCase();
        char[] charArray = str.toCharArray();
        String result = "YES";

        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i)) {
                result = "NO";
            }
        }

        System.out.println(result);

    }

}
