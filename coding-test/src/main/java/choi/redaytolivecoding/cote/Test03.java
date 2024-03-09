package choi.redaytolivecoding.cote;

public class Test03 {

    private static final String DELIMITER = " ";

    public static void main(String[] args) {
        System.out.println(solution(2, "1" +
                "A 2F 1C"));
        System.out.println(solution(1, ""));
        System.out.println(solution(22, "1A 3C 2B 20G 5A"));
    }
    public static int solution(int N, String S) {
        if (S == null || S.isEmpty()) {
            return N * 2;
        }

        boolean[] isReserved = new boolean[N];
        boolean[][] seats = new boolean[N][10];
        String[] reserved = S.split(DELIMITER);
        for (String seat : reserved) {
            int row = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
            char col = seat.charAt(seat.length() - 1);
            int colIndex = col - 'A';

            if (col > 'H') {
                colIndex -= 1;
            }
            isReserved[row] = true;
            seats[row][colIndex] = true;
        }

        int families = 0;
        for (int i = 0; i < N; i++) {
            if (!isReserved[i]) {
                families += 2;
                continue;
            }

            if (!seats[i][1] && !seats[i][2] && !seats[i][3] && !seats[i][4]) {
                seats[i][1] = true;
                seats[i][2] = true;
                seats[i][3] = true;
                seats[i][4] = true;
                families++;
            }
            if (!seats[i][5] && !seats[i][6] && !seats[i][7] && !seats[i][8]) {
                seats[i][5] = true;
                seats[i][6] = true;
                seats[i][7] = true;
                seats[i][8] = true;
                families++;
            }
            if (!seats[i][3] && !seats[i][4] && !seats[i][5] && !seats[i][6]) {
                seats[i][3] = true;
                seats[i][4] = true;
                seats[i][5] = true;
                seats[i][6] = true;
                families++;
            }
        }

        return families;
    }


}
