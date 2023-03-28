package choi.string;

import java.util.Scanner;

public class FlipTheWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        String[] example = new String[num];
        for (int i = 0; i < num; i++) {
            example[i] = in.next();
        }

        for (int i = 0; i < num; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(example[i]);
            StringBuilder reverse = stringBuilder.reverse();

            example[i] = reverse.toString();
        }

        for (int i = 0; i < num; i++) {
            System.out.println(example[i]);
        }
    }

}
