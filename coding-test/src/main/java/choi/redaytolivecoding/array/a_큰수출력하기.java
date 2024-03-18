package choi.redaytolivecoding.array;

import java.util.Scanner;

/**
 * 설명
 *
 * N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
 * (첫 번째 수는 무조건 출력한다)
 *
 *
 * 입력
 * 첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
 *
 *
 * 출력
 * 자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.
 *
 * 6
 * 7 3 9 5 6 12
 *
 * 7 9 6 12
 * */
public class a_큰수출력하기 {

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
