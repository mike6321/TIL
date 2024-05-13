package choi.redaytolivecoding.string;

import java.util.Scanner;

public class d_단어뒤집기_RE {

    public static void main(String[] args){

        Scanner in =new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String str = in.next();

            char[] charArray = str.toCharArray();
            int lt = 0;
            int rt = charArray.length - 1;

            // ready to live coding : lt++ rt-- 단어 뒤집기
            while (lt < rt) {
                char temp = charArray[rt];
                charArray[rt] = charArray[lt];
                charArray[lt] = temp;
                lt++;
                rt--;
            }

            System.out.println(String.valueOf(charArray));

        }
    }

}
