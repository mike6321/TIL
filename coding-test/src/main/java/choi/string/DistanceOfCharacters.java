package choi.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 가장 짧은 문자거리
 * https://cote.inflearn.com/contest/10/problem/01-10
 *
 * teachermode e
 * */
public class DistanceOfCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        char target = t.charAt(0);

        List<Integer> indexes = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                indexes.add(i);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            int temp = Integer.MAX_VALUE;
            for (Integer index : indexes) {
                int abs = Math.abs(index - i);
                if (abs < temp) {
                    temp = abs;
                }
            }
            System.out.print(temp + " ");
        }
    }

}
