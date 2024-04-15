package choi.redaytolivecoding.hackerrank;

public class Test03 {

    public static void main(String[] args) {
        long result = repeatedString("aba", 10);
        System.out.println(result);
    }

    public static long repeatedString(String s, long n) {
        // Write your code here

        char[] charArray = s.toCharArray();
        int aCount = 0;
        for (char c : charArray) {
            if (c == 'a') {
                aCount++;
            }
        }
        long result = n / s.length() * aCount;
        long remain = n % s.length();

        for (int i = 0; i < remain; i++) {
            if (charArray[i] == 'a') {
                result++;
            }
        }


        return result;
    }

}
