package choi.karly;

import java.io.*;

public class Test01 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitInput = input.split(" ");

        int n = Integer.parseInt(splitInput[0]);
        int m = Integer.parseInt(splitInput[1]);

        int totalPizza = n;

        while(n >= m) {
            int pizzaOrderedWithCoupons = n / m;
            totalPizza += pizzaOrderedWithCoupons;
            n = n % m + pizzaOrderedWithCoupons;
        }

        System.out.println(totalPizza);
    }

}
