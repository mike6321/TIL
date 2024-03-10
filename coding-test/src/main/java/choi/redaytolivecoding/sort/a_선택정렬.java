package choi.redaytolivecoding.sort;

import java.util.Scanner;

public class a_선택정렬 {

    /**
     * point : 선택정렬
     * [13] 5 11 7 23 15
     * [13] *5 11 7 23 15 -> 가장 작은 수 찾기
     * [5] 13 11 7 23 15 -> 대상 수와 swap
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = scanner.nextInt();
        }

        int length = array.length;
        for (int i = 0; i < length; i++) {
            int target = array[i];
            int idx = 0;
            for (int j = i + 1; j < length; j++) {
                if (target > array[j]) {
                    idx = j;
                    target = array[j];
                }
            }
            if (idx != 0) {
                swap(array, idx, i);
            }
        }

        for (int i : array) {
            System.out.print(i + " ");
        }

    }

    private static void swap(int[] array, int idx, int i) {
        int temp = array[idx];
        array[idx] = array[i];
        array[i] = temp;
    }

}
