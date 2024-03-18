package choi.redaytolivecoding.string;

import java.util.Scanner;

public class b_대소문자변환_RE {

    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String input = in.next();

        StringBuilder result = new StringBuilder();
        char test = 'z';
        System.out.println((int) test);
        for (char c : input.toCharArray()) {
            /**
             * point : ascii
             * 소문자 : 97 <= x <= 122
             * */
            if (c >= 65 &&  c <= 90) {
                result.append(Character.toLowerCase(c));
            }

            result.append(Character.toUpperCase(c));
        }

        System.out.println(result);

    }

}
