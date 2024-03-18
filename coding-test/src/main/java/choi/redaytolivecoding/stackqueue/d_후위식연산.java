package choi.redaytolivecoding.stackqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 설명
 *
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 *
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 *
 * 입력
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 *
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 *
 *
 * 출력
 * 352+*9-
 * 12
 * */
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
