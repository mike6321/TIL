package choi.redaytolivecoding.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class d_후위식연산 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charArray = scanner.nextLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        for (char c : charArray) {
            if (Character.isDigit(c)) {
                // point! : 런타임 에러가 발생할 수 있으니 이러한 식으로 파싱
                stack.push(c - 48);
            } else {
                if (!stack.isEmpty()) {
                    Integer rightVal = stack.pop();
                    Integer leftVal = stack.pop();

                    if (c == '*') {
                        stack.push(leftVal * rightVal);
                    }
                    if (c == '-') {
                        stack.push(leftVal - rightVal);
                    }
                    if (c == '+') {
                        stack.push(leftVal + rightVal);
                    }
                    if (c == '/') {
                        stack.push(leftVal / rightVal);
                    }
                }
            }
        }

        System.out.println(stack.get(0));
    }
}
