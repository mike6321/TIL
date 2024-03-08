package choi.redaytolivecoding.array;

import java.util.Scanner;

public class c_RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] aArray = new int[n];
        int[] bArray = new int[n];
        for (int i = 0; i < n;i++) {
            aArray[i] = scanner.nextInt();
        }
        for (int i = 0; i < n;i++) {
            bArray[i] = scanner.nextInt();
        }

        /**
         * Point : A가 이기는 경우만 생각 나머진 B 승리
         * 가위(1) 바위(2) 보(3)
         * 1 -> 3
         * 2 -> 1
         * 3 -> 2
         * */
        for (int i = 0; i < n; i++) {
            if (aArray[i] == bArray[i]) {
                System.out.println("D");
            }
            else if (aArray[i] == 1 && bArray[i] == 3 || aArray[i] == 2 && bArray[i] == 1 || aArray[i] == 3 && bArray[i] == 2) {
                System.out.println("A");
            } else {
                System.out.println("B");
            }
        }
    }

}
