package choi.redaytolivecoding.string;

import java.util.Scanner;

/**
 * 설명
 *
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
 *
 * 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
 *
 * teachermode e
 * 1 0 1 2 1 0 1 2 2 1 0
 * */
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
