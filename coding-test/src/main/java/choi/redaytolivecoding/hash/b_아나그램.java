package choi.redaytolivecoding.hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b_아나그램 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        Map<Character, Integer> str1Map = new HashMap<>();
        Map<Character, Integer> str2Map = new HashMap<>();
        if (str1.length() != str2.length()) {
            System.out.println("NO");
            return;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        for (int i = 0; i < charArray1.length; i++) {
            str1Map.put(charArray1[i], str1Map.getOrDefault(charArray1[i], 0) + 1);
            str2Map.put(charArray2[i], str2Map.getOrDefault(charArray2[i], 0) + 1);
        }

        String anwser = "YES";
        for (char c : str1Map.keySet()) {
            Integer str1Key = str1Map.get(c);
            Integer str2Key = str2Map.get(c);

            if (!str1Key.equals(str2Key)) {
                anwser = "NO";
            }
        }

        System.out.println(anwser);



    }

}
