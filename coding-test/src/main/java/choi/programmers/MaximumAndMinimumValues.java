package choi.programmers;

import java.util.Scanner;

/**
 * 최댓값과 최솟값
 * https://school.programmers.co.kr/learn/courses/30/lessons/12939
 *
 * 1 2 3 4
 * -1 -2 -3 -4
 * -1 -1
 * */
public class MaximumAndMinimumValues {

    public static void main(String[] args) {
        MaximumAndMinimumValues maximumAndMinimumValues = new MaximumAndMinimumValues();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String solution = maximumAndMinimumValues.solution(str);
        System.out.println(solution);
    }

    public String solution(String s) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        String[] strings = s.split(" ");
        for (String string : strings) {
            int num = Integer.parseInt(string);
            if (num < minValue) {
                minValue = num;
            }
            if (num > maxValue) {
                maxValue = num;
            }
        }

        return minValue + " " + maxValue;
    }

}
