package choi.redaytolivecoding.sort;

import java.util.Scanner;

public class b_BubbleSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }


        /**
         * point : 버블정렬
         * 가장 큰수를 맨뒤로
         * 13 5 11 7 23 15
         * 13 5 11 7 15 *23
         * */
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (int i : array) {
            System.out.print(i +  " ");
        }

    }

}
