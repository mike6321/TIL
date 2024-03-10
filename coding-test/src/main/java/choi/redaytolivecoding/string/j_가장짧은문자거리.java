package choi.redaytolivecoding.string;

import java.util.Scanner;

public class j_가장짧은문자거리 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        String str = strings[0];
        char target = strings[1].charAt(0);

        char[] charArray = str.toCharArray();
        int[] lengthArray = new int[charArray.length];
        int point = 1000;

        /**
         * Point : 왼쪽에서 길이계산, 오른쪽에서 길이계산
         * 각각의 길이 비교
         * */
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == target) {
                lengthArray[i] = 0;
                point = 0;
                continue;
            }

            ++point;
            lengthArray[i] = point;
        }

        point = 1000;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == target) {
                point = 0;
                continue;
            }

            point++;
            lengthArray[i] = Math.min(lengthArray[i], point);
        }

        for (int i : lengthArray) {
            System.out.print(i + " ");
        }
    }

}
