package choi.redaytolivecoding.stackqueue;

import java.util.Scanner;
import java.util.Stack;

// https://cote.inflearn.com/contest/10/problem/05-01
/**
 * (()(()))(()
 * NO
 * */
public class a_올바른괄호 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] charArray = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        String answer = "YES";

        for (char c : charArray) {
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            answer = "NO";
        }

        System.out.println(answer);
    }

}
