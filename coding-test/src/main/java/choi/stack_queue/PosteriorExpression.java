package choi.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 후위식 연산(postfix)
 * https://cote.inflearn.com/contest/10/problem/05-04
 *
 * 352+*9-
 * */
public class PosteriorExpression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c-48);
            } else {
                Integer pop1 = stack.pop();
                Integer pop2 = stack.pop();

                if (c == '+') {
                    stack.push(pop2 + pop1);
                } else if (c == '-') {
                    stack.push(pop2 - pop1);
                } else if (c == '*') {
                    stack.push(pop2 * pop1);
                } else if (c == '/') {
                    stack.push(pop2 / pop1);
                }
            }
        }

        System.out.println(stack.get(0));
    }

}
