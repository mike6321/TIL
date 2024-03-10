package choi.redaytolivecoding.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class b_괄호문자제거 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (Character c : charArray) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }

        for (Character c : stack) {
            System.out.print(c);
        }
    }

}
