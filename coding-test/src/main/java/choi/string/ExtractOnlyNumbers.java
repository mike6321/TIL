package choi.string;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/01-09
 * */
public class ExtractOnlyNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next().toLowerCase();

        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c >= 48 && c <= 57) {
                answer = (answer * 10) + (c - 48);
            }
        }

        System.out.println(answer);
    }

}
