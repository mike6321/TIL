package choi.go;

import java.util.ArrayList;
import java.util.List;

public class PreTest02 {

    public static void main(String[] args) {
        PreTest02 preTest02 = new PreTest02();

        String line = "11000101111";
        int k = 1;

//        String line = "01";
//        int k = 3;

        String solution = preTest02.solution(line, k);
        System.out.println(solution);
    }

    private List<Integer> getDecimalList(String line) {
        char[] strList = line.toCharArray();
        char differStr = strList[0];
        int count = 1;
        List<Integer> decimal = new ArrayList<>();

        for (int i = 1; i < strList.length; i++) {
            if (differStr == strList[i]) {
                count++;
            } else {
                decimal.add(count);
                differStr = strList[i];
                count = 1;
            }

            if (i == strList.length - 1) {
                decimal.add(count);
            }
        }
        return decimal;

    }

    private String getDecimalToBinary(String line) {
        String binaryStr = "";
        List<Integer> decimalList = getDecimalList(line);
        for (int i : decimalList) {
            binaryStr += Integer.toBinaryString(i);
        }

        return binaryStr;
    }

    private String solution(String line, int k) {
        String answer = "";

        for (int i = 0; i < k; i++) {
            answer = getDecimalToBinary(line);
            line = answer;
        }

        return answer;
    }

}
