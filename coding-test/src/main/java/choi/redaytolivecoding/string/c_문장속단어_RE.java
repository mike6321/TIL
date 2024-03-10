package choi.redaytolivecoding.string;

import java.util.Scanner;

public class c_문장속단어_RE {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int m = Integer.MIN_VALUE;
        int position = 0;
        String answer = null;
        while ((position = s.indexOf(' ')) != -1) {
            String tmp = s.substring(0, position);
            int length = tmp.length();

            if (m < length) {
                m = length;
//                answer = tmp;
            }

            s = s.substring(position + 1);
            if (s.length() > m) {
                answer = s;
            }
        }
        System.out.println(answer);
    }

}
