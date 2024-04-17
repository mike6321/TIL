package choi.redaytolivecoding.uplus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test03 {

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        String result = test03.solution("ABCabcA");
        System.out.println(result);
    }

    public String solution(String interview) {
        String lowerInterview = interview.toLowerCase();
        Map<String, Integer> frequencyMap = new HashMap<>();
        int maxFrequency = 0;

        // 모든 가능한 부분 문자열을 찾아서 빈도를 계산
        for (int start = 0; start < lowerInterview.length(); start++) {
            for (int end = start + 1; end <= lowerInterview.length(); end++) {
                String sub = lowerInterview.substring(start, end);
                int count = frequencyMap.getOrDefault(sub, 0) + 1;
                frequencyMap.put(sub, count);
                maxFrequency = Math.max(maxFrequency, count);
            }
        }

        // 최대 빈도를 가진 패턴들을 찾기
        List<String> maxPatterns = new ArrayList<>();
        for (String key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == maxFrequency) {
                maxPatterns.add(key);
            }
        }

        // 원본 문자열에서 모든 최대 빈도 패턴을 삭제
        String result = interview;
        for (String pattern : maxPatterns) {
            result = result.replaceAll("(?i)" + pattern, "");
        }

        return result;
    }


}
