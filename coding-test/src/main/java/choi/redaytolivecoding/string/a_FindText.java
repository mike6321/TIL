package choi.redaytolivecoding.string;

import java.util.Scanner;

public class a_FindText {

    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        String input = in.next().toLowerCase();
        char target = in.next().toLowerCase().charAt(0);

        int count = 0;
        /**
         * point : toCharArray
         * */
        for (char c : input.toCharArray()) {
            if (c == target) {
                count++;
            }
        }
        System.out.println(count);
    }

}