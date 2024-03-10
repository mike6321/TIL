package choi.redaytolivecoding.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class c_크레인인형뽑기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[][] board = new int[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int num = scanner.nextInt();
        int[] moves = new int[num];
        for (int i = 0; i < num; i++) {
            moves[i] = scanner.nextInt();
        }
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num; i++) {
            int target = moves[i];

            for (int k = 0; k < length; k++) {
                int now = board[k][target - 1];
                if (now != 0) {
                    if (!stack.isEmpty()) {
                        Integer peek = stack.peek();
                        if (peek.equals(now)) {
                            stack.pop();
                            result++;
                        } else {
                            stack.push(now);
                        }
                    } else {
                        stack.push(now);
                    }
                    board[k][target - 1] = 0;
                    break;
                }
            }
        }

        System.out.println(result * 2);
    }
}
