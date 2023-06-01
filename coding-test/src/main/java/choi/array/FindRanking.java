package choi.array;

import java.util.Scanner;

public class FindRanking {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int target = arr[i];
            int count = 1;
            for (int j = 0; j < n; j++) {
                if (target < arr[j]) {
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }

}
