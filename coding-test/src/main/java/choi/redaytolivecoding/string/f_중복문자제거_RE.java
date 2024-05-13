package choi.redaytolivecoding.string;

import java.util.Scanner;

public class f_중복문자제거_RE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        // ready to live coding : charAt을 활용하여 해당 문자의 첫번째 인덱스 구하기
        for (int i = 0; i < str.length(); i++) {
            if (i == str.indexOf(str.charAt(i))) {
                System.out.print(str.charAt(i));
            }
        }

    }

}
