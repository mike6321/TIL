package choi.programmers;

import java.util.Arrays;

public class CreateMinimum {

    public static void main(String[] args) {
        CreateMinimum createMinimum = new CreateMinimum();
//        int[] A = {1, 4, 2};
//        int[] B = {5, 4, 4};

        int[] A = {1, 2};
        int[] B = {3, 4};

        System.out.println(createMinimum.solution(A, B));
    }

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int length = A.length;
        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length - i -1];
        }

        return answer;
    }

}
