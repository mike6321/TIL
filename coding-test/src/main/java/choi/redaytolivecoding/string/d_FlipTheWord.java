package choi.redaytolivecoding.string;

import java.util.Scanner;

public class d_FlipTheWord {

    public static void main(String[] args){

        Scanner in =new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            String str = in.next();
            StringBuilder reverse = sb.append(str).reverse();
            System.out.println(reverse);
        }
    }

}
