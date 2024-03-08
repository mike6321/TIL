package choi.redaytolivecoding.array;

import java.util.Scanner;

public class a_LargeNumberOutput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            array[i] = num;
        }

        System.out.print(array[0]);
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] < array[i]) {
                System.out.print(" " + array[i]);
            }
        }
    }
}
