package choi.redaytolivecoding.array;

import java.util.Scanner;

public class d_피보나치수열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int[] array = new int[num];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i < num; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        for (int i : array) {
            System.out.print(i + " ");
        }

    }

}
