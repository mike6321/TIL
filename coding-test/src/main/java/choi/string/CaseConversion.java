package choi.string;

import java.util.Scanner;

public class CaseConversion {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String input1 = in.nextLine();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input1.length(); i++) {
            char targetChar = input1.charAt(i);

            if (Character.isLowerCase(targetChar)) {
                result.append(Character.toUpperCase(targetChar));
            }
            if (Character.isUpperCase(targetChar)) {
                result.append(Character.toLowerCase(targetChar));
            }
        }

        System.out.println(result);
    }

}
