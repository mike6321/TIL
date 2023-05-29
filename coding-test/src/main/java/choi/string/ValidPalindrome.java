package choi.string;

import java.util.Scanner;

/**
 * 유효한 팰린드롬
 * https://cote.inflearn.com/contest/10/problem/01-08
 *
 * found7, time: study; Yduts; emit, 7Dnuof
 * */
public class ValidPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 대문자 알파벳 제외한 나머지 문자열 공백 대치
        String str = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        String temp = new StringBuilder(str).reverse().toString();

        String result = "NO";
        if (str.equals(temp)) {
            result = "YES";
        }

        System.out.println(result);
    }

}
