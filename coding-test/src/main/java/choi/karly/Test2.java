package choi.karly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] eatTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] heatTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        // sort!
        Integer[] indices = new Integer[heatTimes.length];
        for (int i = 0; i < heatTimes.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> (eatTimes[b] - eatTimes[a]));

        int totalHeatTime = 0;
        int totalTime = 0;

        for (int i : indices) {
            totalHeatTime += heatTimes[i];
            totalTime = Math.max(totalHeatTime, totalHeatTime + eatTimes[i]);
        }

        System.out.println(totalTime);
    }

}
