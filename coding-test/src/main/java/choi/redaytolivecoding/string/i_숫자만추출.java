package choi.redaytolivecoding.string;

import java.util.Scanner;

public class i_숫자만추출 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        String str1 = str.replaceAll("[^0-9]", "");
        System.out.println(Integer.parseInt(str1));
    }

}
