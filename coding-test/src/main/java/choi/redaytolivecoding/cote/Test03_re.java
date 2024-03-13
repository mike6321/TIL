package choi.redaytolivecoding.cote;

public class Test03_re {

    public static void main(String[] args) {
        System.out.println(solution(2, "1A 2F 1C"));
        System.out.println(solution(1, ""));
        System.out.println(solution(22, "1A 3C 2B 20G 5A"));
    }

    public static int solution(int N, String S) {
        if (S.isEmpty()) {
            return N * 2;
        }

        String[] target = S.split(" ");
        boolean[][] seats = new boolean[N][10];
        boolean[] isReserved = new boolean[N];

        for (String str : target) {
            char col = str.charAt(str.length() - 1);
            int rowIndex = Integer.parseInt(str.substring(0, str.length() - 1)) - 1;
            int colIndex = col > 'H' ? col - 'A' - 1 : col - 'A';

            seats[rowIndex][colIndex] = true;
            isReserved[rowIndex] = true;
        }


        int total = 0;
        for (int i = 0; i < N; i++) {
            if (!isReserved[i]) {
                total += 2;
                continue;
            }

            if (!seats[i][1] && !seats[i][2] && !seats[i][3] && !seats[i][4]) {
                seats[i][1] = true;
                seats[i][2] = true;
                seats[i][3] = true;
                seats[i][4] = true;

                total++;
            }

            if (!seats[i][5] && !seats[i][6] && !seats[i][7] && !seats[i][8]) {
                seats[i][5] = true;
                seats[i][6] = true;
                seats[i][7] = true;
                seats[i][8] = true;

                total++;
            }

            if (!seats[i][3] && !seats[i][4] && !seats[i][5] && !seats[i][6]) {
                seats[i][3] = true;
                seats[i][4] = true;
                seats[i][5] = true;
                seats[i][6] = true;

                total++;
            }
        }





        return total;
    }


}
