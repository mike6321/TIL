package choi.redaytolivecoding.string;

import java.util.Scanner;

public class h_ValidPalindrome {

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
