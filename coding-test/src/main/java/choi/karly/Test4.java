package choi.karly;
import java.io.*;

public class Test4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] tokens = input.split(" ");

        int a = Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);

        int maxCycleLength = 0;
        for (int n = a; n <= b; n++) {
            int cycleLength = getCycleLength(n);
            maxCycleLength = Math.max(maxCycleLength, cycleLength);
        }

        System.out.println(maxCycleLength);
    }

    private static int getCycleLength(int n) {
        int cycleLength = 1;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }

            cycleLength++;
        }

        return cycleLength;
    }


}
