package choi.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 올바른 괄호
 * https://cote.inflearn.com/contest/10/problem/05-01
 *
 * (()(()))(()
 * */
public class CorrectionBracket {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();

        String result = "YES";
        for (char aChar : chars) {
            if (aChar == '(') {
                stack.push(aChar);
            } else {
                if (stack.isEmpty()) {
                    result = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (!stack.isEmpty()) {
            result = "NO";
        }

        System.out.println(result);

    }

}
