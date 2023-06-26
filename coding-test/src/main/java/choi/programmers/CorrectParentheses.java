package choi.programmers;

import java.util.Scanner;
import java.util.Stack;

/**
 * 올바른 괄호
 * https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * 
 * ()()
 * (())()
 * )()(
 * (()(
 * */
public class CorrectParentheses {

    public static void main(String[] args) {
        CorrectParentheses correctParentheses = new CorrectParentheses();
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(correctParentheses.solution(s));
    }

    boolean solution(String s) {
        boolean answer = true;

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char target : chars) {
            if (target == '(') {
                stack.push(target);
            } else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            answer = false;
        }

        return answer;
    }

}
