package choi.redaytolivecoding.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class f_뒤집은소수 {

    /**
     * 아예 접근 못함
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];

        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int temp = array[i];
            int res = 0;

            /**
             * point : 숫자 뒤집기 (기억해두기)
             * */
            while (temp > 0) {
                int t = temp % 10;
                res = res * 10 + t;
                temp = temp / 10;
            }

            if (isPrime(res)) {
                result.add(res);
            }
        }
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    /**
     * point : 소수 판단
     * */
    public static boolean isPrime(int res) {
        if (res == 1) {
            return false;
        }

        for (int i = 2; i < res; i++) {
            if (res % i == 0) {
                return false;
            }
        }

        return true;
    }

}
