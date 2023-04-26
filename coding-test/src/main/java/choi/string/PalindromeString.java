package choi.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-07
 * */
public class PalindromeString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next().toLowerCase();

        String result = "YES";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char target1 = str.charAt(i);
            char target2 = str.charAt(length - i - 1);

            if (target1 != target2) {
                result = "NO";
                break;
            }
        }

        System.out.println(result);

    }

}
