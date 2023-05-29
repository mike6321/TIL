package choi.string;

import java.util.Scanner;

/**
 * 숫자만 추출
 * https://cote.inflearn.com/contest/10/problem/01-09
 *
 * g0en2T0s8eSoft
 * */
public class ExtractNumbersOnly {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next().replaceAll("[^0-9]", "");

        System.out.println(Integer.parseInt(s));
    }

}
