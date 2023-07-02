package choi.greedy;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/10-01
 *
 * 7
 * 21
 * */
public class 계단오르기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] dy = new int[n+1];

        계단오르기 problem = new 계단오르기();
        int answer = problem.solution(dy, n);

        System.out.println(answer);
    }

    private int solution(int[] dy, int n) {
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i-1] + dy[i-2];
        }
        return dy[n];
    }

}
