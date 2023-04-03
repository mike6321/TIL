package choi.string;

import java.util.*;

/**
 * https://cote.inflearn.com/contest/10/problem/01-05
 * */
public class FlipSpecificCharacters {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String input1 = in.next();

        char[] chars = input1.toCharArray();
        Queue<Character> alphabetic = new LinkedList<>();
        Map<Integer, Character> nonAlphabetic = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            char unit = chars[i];
            if (Character.isAlphabetic(unit)) {
                alphabetic.add(unit);
            } else {
                nonAlphabetic.put(i, unit);
            }
        }

        int length = input1.length();
        String[] result = new String[length];

        for (Map.Entry<Integer, Character> integerCharacterEntry : nonAlphabetic.entrySet()) {
            result[integerCharacterEntry.getKey()] = String.valueOf(integerCharacterEntry.getValue());
        }

        for (int i = length - 1; i > -1; i--) {
            if (result[i] == null) {
                Character poll = alphabetic.poll();
                result[i] = String.valueOf(poll);
            }
        }

        for (String s : result) {
            System.out.print(s);
        }
    }

}
