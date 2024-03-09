package org.example.card;

import java.util.*;

public class Test03 {

    private static String result = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt(); // 패스워드 길이 (사용 x)
        int wordCount = scanner.nextInt(); // 단어의 개수
        scanner.nextLine(); // 줄 바꿈 처리
        String pattern = scanner.nextLine(); // 패턴 입력
        List<String> words = new ArrayList<>();
        for (int i = 0; i < wordCount; i++) {
            words.add(scanner.nextLine()); // 단어 입력
        }

        // 단어들을 사전 순으로 정렬
        Collections.sort(words);

        String result = findPassword(pattern, words, 0, "");
        System.out.println(result != null ? result : "No valid password found");
    }

    private static String findPassword(String pattern, List<String> words, int start, String currentPassword) {
        if (currentPassword.length() == pattern.length()) {
            if (currentPassword.matches(pattern.replaceAll("\\?", "."))) {
                return currentPassword;
            }
            return null;
        }

        for (String word : words) {
            // 현재 패스워드에 단어를 추가한 새 패스워드 후보 생성
            String newPassword = currentPassword + word;
            // 새 패스워드 후보가 패턴과 일치하는지 확인
            if (newPassword.length() <= pattern.length() && matchPattern(pattern, newPassword)) {
                String result = findPassword(pattern, words, start + 1, newPassword);
                if (result != null) {
                    return result;
                }
            }
        }

        return null; // 일치하는 패스워드를 찾지 못함
    }

    // 패턴과 패스워드 후보가 일치하는지 확인
    private static boolean matchPattern(String pattern, String password) {
        if (password.length() > pattern.length()) {
            return false;
        }
        for (int i = 0; i < password.length(); i++) {
            char patternChar = pattern.charAt(i);
            char passwordChar = password.charAt(i);
            if (patternChar != '?' && patternChar != passwordChar) {
                return false;
            }
        }
        return true;
    }
}
