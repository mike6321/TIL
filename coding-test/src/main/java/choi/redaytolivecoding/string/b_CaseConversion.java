package choi.redaytolivecoding.string;

import java.util.Scanner;

public class b_CaseConversion {

    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String input = in.next();

        StringBuilder result = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append(Character.toLowerCase(c));
                continue;
            }

            result.append(Character.toUpperCase(c));
        }

        System.out.println(result);

    }

}
