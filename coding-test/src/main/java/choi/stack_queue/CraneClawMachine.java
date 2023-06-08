package choi.stack_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 크레인 인형뽑기(카카오)
 * https://cote.inflearn.com/contest/10/problem/05-03
 *
5
0 0 0 0 0
0 0 1 0 3
0 2 5 0 1
4 2 4 4 2
3 5 1 3 1
8
1 5 3 5 1 2 1 4
 * */

public class CraneClawMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = boardInit(scanner, n);
        int m = scanner.nextInt();
        int[] move = moveInit(scanner, m);
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int pos : move) {
            for (int j = 0; j < n; j++) {
                int target = board[j][pos-1];
                board[j][pos-1] = 0;
                if (target != 0) {
                    if (!stack.isEmpty() && target == stack.peek()) {
                        stack.pop();
                        result += 2;
                    } else {
                        stack.push(target);
                    }
                    break;
                }
            }
        }
        System.out.println(result);
    }

    private static int[] moveInit(Scanner scanner, int m) {
        int[] move = new int[m];
        for (int i = 0; i < m; i++) {
            move[i] = scanner.nextInt();
        }
        return move;
    }

    private static int[][] boardInit(Scanner scanner, int n) {
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        return board;
    }

}
