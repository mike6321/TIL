package choi.string;

import java.util.*;

/**
 * https://cote.inflearn.com/contest/10/problem/01-06
 * */
public class RemoveDuplicateCharacters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.next();

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!list.contains(c)) {
                list.add(c);
            }
        }

        for (Character character : list) {
            System.out.print(character);
        }
    }

}
