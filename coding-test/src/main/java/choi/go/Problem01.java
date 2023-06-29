package choi.go;

/**
 * 100000000
 * */
public class Problem01 {

    public static void main(String[] args) {
        int mod1 = 4;
        int mod2 = 3;
        int maxRange = 20;
        Problem01 problem01 = new Problem01();
        int solution = problem01.solution(mod1, mod2, maxRange);

        System.out.println(solution);
    }

    public int solution(int mod1, int mod2, int max_range) {
        int answer = 0;
        boolean[] check = new boolean[max_range+1];

        for (int i = max_range; i > mod1; i--) {
            if (max_range % mod1 == 0) {
                break;
            }
            if (i % mod1 == 0) {
                max_range = i;
                break;
            }
        }

        for (int i = mod1; i <= max_range; i += mod1) {
            if (check[i]) {
                return answer;
            }
            if (i % mod2 != 0) {
                answer++;
            }
            if (max_range % mod2 != 0) {
                answer++;
            }
            max_range -= mod1;
            check[max_range] = true;
        }

        return answer;
    }

}
