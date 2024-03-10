package choi.redaytolivecoding.string;

import java.util.Scanner;

public class h_유효한팰린드롬 {

    public static void main(String[] args) {
        String result = "NO";
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toUpperCase().replaceAll("[^A-Z]", "");

        String reverse = new StringBuilder(str).reverse().toString();

        if (str.equals(reverse)) {
            result = "YES";
        }

        System.out.println(result);
    }

}
