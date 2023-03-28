package choi.string;

import java.util.Locale;
import java.util.Scanner;

public class FindText {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String input1 = in.nextLine();
        String input2 = in.nextLine();

        String input1Lower = input1.toLowerCase(Locale.ROOT);
        String input2Lower = input2.toLowerCase(Locale.ROOT);
        char targetChar = input2Lower.charAt(0);

        int result = 0;
        for (int i = 0; i < input1Lower.length(); i++) {
            char splitChar = input1Lower.charAt(i);
            if (targetChar == splitChar) {
                result++;
            }
        }

        System.out.println(result);
    }
    
}
