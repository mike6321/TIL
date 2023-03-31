package choi.sort;

import java.util.Scanner;

public class BubbleSort {

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

    private static int[] solution(int loopNum, int[] arr) {
        for (int i = 0; i < loopNum-1; i++) { // 마지막 요소는 안돌아도된다.
            for (int j = 0; j < loopNum-1-i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

}
