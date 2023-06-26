package choi.programmers;

import java.util.Locale;
import java.util.Scanner;

/**
 * JadenCase 문자열 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12951
 * */
public class JadenCase {

    public static void main(String[] args) {
        JadenCase jadenCase = new JadenCase();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(jadenCase.solution(s));
    }

    public String solution(String s) {
        String answer = "";
        String[] strings = s.split(" ");

        for (int i = 0; i < strings.length; i++) {
            String target = strings[i];

            if (target.length() == 0) {
                answer += " ";
            } else {
                answer += target.substring(0, 1).toUpperCase();
                answer += target.substring(1).toLowerCase();
                answer += " ";
            }
        }

        int length = answer.length();
        if (s.charAt(s.length() - 1) == ' ') {
            return answer;
        }

        return answer.substring(0, length - 1);
    }

}
