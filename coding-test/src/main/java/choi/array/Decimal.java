package choi.array;

import java.util.Scanner;

/**
 * 소수(에라토스테네스 체)
 * https://cote.inflearn.com/contest/10/problem/02-05
 * */
public class Decimal {

    private static int[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        check = new int[num+1];
        int answer = 0;
        for (int i = 2; i <= num; i++) {
            if (check[i] == 0) {
                answer++;
                for (int j=i; j <= num; j=j+i) {
                    check[j] = 1;
                }
            }
        }
        System.out.println(answer);
    }

}
