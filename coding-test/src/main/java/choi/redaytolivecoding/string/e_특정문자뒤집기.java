package choi.redaytolivecoding.string;

import java.util.Scanner;

public class e_특정문자뒤집기 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] charArray = str.toCharArray();
        int lt = 0;
        int rt = charArray.length - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])){
                rt--;
            } else {
                char temp = charArray[rt];
                charArray[rt] = charArray[lt];
                charArray[lt] = temp;
                lt++;
                rt--;
            }
        }

        System.out.println(String.valueOf(charArray));
    }

}
