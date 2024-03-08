package choi.redaytolivecoding.array;

import java.util.Scanner;

public class b_VisibleStudent {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int count = 1;
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (max < array[i]) {
                count++;
                max = array[i];
            }
        }

        System.out.println(count);
    }

}
