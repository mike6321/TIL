package choi.karly;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
3
1 2 3
1 2

3
1 2 3
1 2 1
 * */
public class Test2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 먹는데 걸리는 시간과 데우는 시간 입력 받기
        int[] eatTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] heatTimes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        // 먹는 시간에 따라 내림차순으로 정렬하는 과정에 필요한 배열을 생성
        Integer[] indices = new Integer[eatTimes.length];
        for (int i = 0; i < heatTimes.length; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> (eatTimes[b] - eatTimes[a]));

        int totalHeatTime = 0;
        int totalTime = 0;

        for (int i : indices) {
            totalHeatTime += heatTimes[i]; // 현재 햄버거를 데우는 시간을 누적
            totalTime = Math.max(totalHeatTime, totalHeatTime + eatTimes[i]);  // 전체 시간 업데이트
        }

        System.out.println(totalTime);
    }

}
