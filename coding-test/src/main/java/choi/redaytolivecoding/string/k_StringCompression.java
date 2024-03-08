package choi.redaytolivecoding.string;

import java.util.Scanner;

public class k_StringCompression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /**
         * point : index error 를 방지하기 위해 빈문자열 추가
         * */
        String str = scanner.nextLine() + " ";
        char[] charArray = str.toCharArray();

        StringBuilder result = new StringBuilder();
        int count = 1;
        /**
         * point  : 논리적인 작업순서
         * */
        for (int i = 0; i < charArray.length - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                result.append(str.charAt(i));
                if (count > 1) {
                    result.append(count);
                }
                count = 1;
            }

        }

        System.out.println(result);
    }


}
