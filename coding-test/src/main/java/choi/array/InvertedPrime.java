package choi.array;

import java.util.Scanner;

/**
 * 뒤집은 소수
 * https://cote.inflearn.com/contest/10/problem/02-06
 *
9
32 55 62 20 250 370 200 30 100
 * */
public class InvertedPrime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();

            int reverse = getReverse(num);

            array[i] = reverse;
        }

        for (int i = 0; i < n; i++) {
            if (primeCheck(array[i])) {
                System.out.print(array[i] + " ");
            }
        }
    }

    // 숫자 뒤집기
    private static int getReverse(int num) {
        int reverse = 0;
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return reverse;
    }

    // 소수 체크
    public static boolean primeCheck(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
