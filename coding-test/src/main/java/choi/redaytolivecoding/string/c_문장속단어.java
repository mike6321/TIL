package choi.redaytolivecoding.string;

import java.util.Scanner;

/**
 * it is time to study
 *
 * study
 * */
public class c_문장속단어 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String[] strings = in.nextLine().split(" ");

        int count = Integer.MIN_VALUE;
        String result = null;
        for (String string : strings) {
            if (count <= string.length()) {
                result = string;
                count = string.length();
            }
        }

        System.out.println(result);
    }

}
