package choi.sort;

import java.util.Scanner;

/**
 * 오름차순 선택정렬
 * https://cote.inflearn.com/contest/10/problem/06-01
 * */
public class SelectionSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int loopNum = in.nextInt();
        int[] arr = new int[loopNum];
        for (int i = 0; i < loopNum; i++) {
            int num = in.nextInt();
            arr[i] = num;
        }

        int[] solution = solution(loopNum, arr);
        for (int result : solution) {
            System.out.print(result + " ");
        }
    }

    public static int[] solution(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            int index = i; // 가장 작은 값 인덱스

            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }

            swqp(arr, i, index);
        }

        return arr;
    }

    private static void swqp(int[] arr, int i, int index) {
        int temp = arr[i];
        arr[i] = arr[index];
        arr[index] = temp;
    }

}
