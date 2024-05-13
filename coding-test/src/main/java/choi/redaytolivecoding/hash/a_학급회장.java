package choi.redaytolivecoding.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class a_학급회장 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = scanner.next();
        char[] charArray = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : charArray) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char answer = ' ';
        int max = Integer.MIN_VALUE;
        for (char c : map.keySet()) {
            Integer value = map.get(c);
            if (max < value) {
                max = value;
                answer = c;
            }
        }

        System.out.println(answer);
    }

}
