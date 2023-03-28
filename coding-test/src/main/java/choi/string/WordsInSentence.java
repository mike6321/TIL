package choi.string;

import java.util.Scanner;

public class WordsInSentence {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        String input1 = in.nextLine();

        String[] strings = input1.split(" ");

        String result = strings[0];

        for (int i = 1; i < strings.length; i++) {
            if (result.length() < strings[i].length()) {
                result = strings[i];
            }
        }

        System.out.println(result);
    }

}
