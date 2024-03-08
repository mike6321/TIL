package choi.redaytolivecoding.array;

import java.util.Scanner;

public class d_Fibonacci_RE {

    /**
     * point : 배열쓰지마라
     * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int a = 1;
        int b = 1;
        int c = 0;
        System.out.println(a);
        System.out.println(b);
        for (int i = 2; i < num; i++) {
            c = a + b;
            System.out.println(c);
            a = b;
            b = c;
        }
    }

}
