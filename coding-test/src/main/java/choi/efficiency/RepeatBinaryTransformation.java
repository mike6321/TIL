package choi.efficiency;

import java.util.List;

/**
 * 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 *
 * 110010101001
 * 01110
 * 1111111
 * */
public class RepeatBinaryTransformation {

    public static void main(String[] args) {
        RepeatBinaryTransformation repeatBinaryTransformation = new RepeatBinaryTransformation();
        String s = "110010101001";

        int[] solution = repeatBinaryTransformation.solution(s);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }

    public int[] solution(String s) {
        int count = 0;
        int removeZeroCount = 0;
        int[] answer = {count, removeZeroCount};

        while (!s.equals("1")) {
            char[] array = s.toCharArray();
            int length = 0;

            for (char c : array) {
                if (c == '0') {
                    answer[1]++;
                } else {
                    length++;
                }
            }

            answer[0]++;

            s = Integer.toBinaryString(length);
        }
        return answer;
    }

}
