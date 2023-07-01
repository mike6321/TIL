package choi.efficiency;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/03-05
 * 15
 * */
public class 연속된_자연수의_합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        연속된_자연수의_합 problem = new 연속된_자연수의_합();
        int answer = problem.solution(n);
        System.out.println(answer);
    }

    private int solution(int n) {
        int sum = 0;
        int answer = 0;
        int lt = 0;
        int m = (n / 2) + 1;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }

            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;

    }

}
