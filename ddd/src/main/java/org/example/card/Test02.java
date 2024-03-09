package org.example.card;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Test02 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            StringBuilder newWord = new StringBuilder();

            // 첫 번째 문자는 항상 추가
            newWord.append(word.charAt(0));

            for (int j = 1; j < word.length(); j++) {
                char current = word.charAt(j);
                char previous = word.charAt(j - 1);

                if (isVowel(current) && isVowel(previous)) {
                    continue;
                }
                newWord.append(current);
            }

            System.out.println(newWord);
        }
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) >= 0;
    }

}
