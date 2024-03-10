package choi.redaytolivecoding.array;

import java.util.Scanner;

public class e_소수 {

    /**
     * point : 각각의 수의 곱을 체크
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 2; i < num;i++) {
            for (int j = i; j < num; j+=i) {
                array[j]++;
            }
        }

        int count = 0;
        for (int i = 0; i < num; i++) {
            if (array[i] == 1) {
                count++;
            }
        }

        System.out.println(count);

    }

}
