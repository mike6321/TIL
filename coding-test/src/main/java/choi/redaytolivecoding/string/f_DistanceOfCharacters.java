package choi.redaytolivecoding.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class f_DistanceOfCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Set<Character> set = new HashSet<>();
        char[] charArray = str.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : charArray) {
            if (set.contains(c)) {
                continue;
            }
            result.append(c);
            set.add(c);
        }

        System.out.println(result);
    }

}
