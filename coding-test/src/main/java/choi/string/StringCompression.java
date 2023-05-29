package choi.string;

import java.util.Scanner;

/**
 * 문자열 압축
 * https://cote.inflearn.com/contest/10/problem/01-11
 *
 * KKHSSSSSSSE
 * */
public class StringCompression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        char[] chars = s.toCharArray();
        int index;
        for (int i = 0; i < chars.length; i += index) {
            char target = chars[i];
            index = 1;
            System.out.print(target);
            for (int j = i+1; j < chars.length; j++) {
                if (chars[j] == target) {
                    index++;
                    if (j == chars.length -1) {
                        System.out.print(index);
                    }
                    continue;
                }
                if (index > 1) {
                    System.out.print(index);
                }
                break;
            }
        }
        System.out.println();
    }

}
