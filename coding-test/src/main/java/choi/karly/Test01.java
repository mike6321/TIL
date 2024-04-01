package choi.karly;

import java.io.*;

public class Test01 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] splitInput = input.split(" ");

        int n = Integer.parseInt(splitInput[0]); // 피자 갯수
        int m = Integer.parseInt(splitInput[1]); // 피자 한판 교환가능한 쿠폰 갯수

        int totalPizza = n;

        while(n >= m) {
            int pizzaOrderedWithCoupons = n / m;
            totalPizza += pizzaOrderedWithCoupons;
            int divide = n % m; // 남은것
            n = divide + pizzaOrderedWithCoupons;
        }

        System.out.println(totalPizza);
    }

}
