package choi.redaytolivecoding.sort;

import java.util.Scanner;

public class c_InsertionSort {

    public static void main(String[] args) {
        /**
         * point : 삽입정렬
         * 11 [7] | 5 6 10 9
         * 11 11 | 5 6 10 9
         * [7] 11 | 5 6 10 9
         *
         * 7 11 [5]  | 6 10 9
         * 7 11 11  | 6 10 9
         * 7 7 11  | 6 10 9
         * [5] 7 11  | 6 10 9
         *
         * 5 7 11 [6] | 10 9
         * 5 7 11 11 | 10 9
         * 5 7 7 11 | 10 9
         * 5 [6] 7 11 | 10 9
         * */
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 1; i < array.length; i++) {
            int target = array[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (target < array[j]) {
                    array[j+1] = array[j];
                    for (int a : array) {
                        System.out.print(a + " ");
                    }
                    System.out.println();
                } else {
                    break;
                }
            }
            // 삽입
            array[j+1] = target;
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
