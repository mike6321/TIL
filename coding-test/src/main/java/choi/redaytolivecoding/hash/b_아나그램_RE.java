package choi.redaytolivecoding.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b_아나그램_RE {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        Map<Character, Integer> strMap = new HashMap<>();

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        for (char c : charArray1) {
            strMap.put(c, strMap.getOrDefault(c, 0) + 1);
        }

        String answer = "YES";
        for (char c : charArray2) {
            if (!strMap.containsKey(c) || strMap.get(c) == 0) {
                System.out.println("NO");
                return;
            }
            strMap.put(c, strMap.get(c) - 1);
        }

        System.out.println(answer);
    }

}
