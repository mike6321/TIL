package choi.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 쇠막대기
 * https://cote.inflearn.com/contest/10/problem/05-05
 *
 * ()(((()())(())()))(())
 * */
public class IronRod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i-1) == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}
