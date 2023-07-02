package choi.efficiency;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/03-04

8 6
1 2 1 3 1 1 1 2
 * */
public class 연속_부분수열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        연속_부분수열 problem = new 연속_부분수열();
        int answer = problem.solution(n, m, array);
        System.out.println(answer);
    }

    private int solution(int n, int m, int[] array) {
        int answer = 0;
        int sum = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += array[rt];
            if (sum == m) {
                answer++;
            }

            while (sum >= m) {
                sum -= array[lt++];
                if (sum == m) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
