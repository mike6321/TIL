package choi.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 괄호문자제거
 * https://cote.inflearn.com/contest/10/problem/05-02
 *
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 * */
public class RemoveBracketCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Stack<Character> stack = new Stack<>();

        for (char aChar : str.toCharArray()) {
            if (aChar == ')') {
                while (stack.pop() != '(');

            } else {
                stack.push(aChar);
            }
        }

        for (Character character : stack) {
            System.out.print(character);
        }
    }

}
