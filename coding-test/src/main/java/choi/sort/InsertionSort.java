package choi.sort;

import java.util.Scanner;

/**
 * https://cote.inflearn.com/contest/10/problem/06-03
 * */
public class InsertionSort {

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

    /**
     * 6
     * 11 7 5 6 10 9
     *
     * temp: 7
     * 11 [7] 5 6 10 9
     * [7] 11 5 6 10 9
     * -1 번 인덱스에서 loop 빠져나옴
     * -1 + 1 = 0 인덱스에 temp 삽입
     *
     * temp: 5
     * 7 11 [5] 6 10 9
     * 7 [5] 11 6 10 9
     * [5] 7 11 6 10 9
     * -1 번 인덱스에서 loop 빠져나옴
     * -1 + 1 = 0 인덱스에 temp 삽입
     *
     * temp: 6
     * 5 7 11 [6] 10 9
     * 5 7 [6] 11 10 9
     * 5 [6] 7 11 10 9
     * 0 번 인덱스에서 loop 빠져나옴
     * 0 + 1 = 1 인덱스에 temp 삽입
     *
     * 
     * */
    private static int[] solution(int loopNum, int[] arr) {
        for (int i = 1; i < loopNum; i++) {
            int j;
            int temp = arr[i];
            for (j = i-1; j >= 0; j--) {
                if (temp < arr[j]) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
        return arr;
    }

}
