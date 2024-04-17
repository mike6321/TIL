package choi.redaytolivecoding.uplus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test02 {

    private static final int DAY_MINUTES = 1440; // 하루 분 수
    private static Map<String, Integer> dayToMinutes = Map.of(
            "MO", 0 * DAY_MINUTES,
            "TU", 1 * DAY_MINUTES,
            "WE", 2 * DAY_MINUTES,
            "TH", 3 * DAY_MINUTES,
            "FR", 4 * DAY_MINUTES
    );

    public int solution(String[][] schedule) {
        List<List<int[]>> courses = parseSchedule(schedule);
        return countValidSchedules(courses, 0, new ArrayList<>());
    }

    private List<List<int[]>> parseSchedule(String[][] schedule) {
        List<List<int[]>> courses = new ArrayList<>();
        for (String[] course : schedule) {
            List<int[]> slots = new ArrayList<>();
            for (String time : course) {
                slots.add(parseTime(time));
            }
            courses.add(slots);
        }
        return courses;
    }

    private int[] parseTime(String time) {
        String[] parts = time.split(" ");
        int[] times = new int[parts.length / 2 * 2];
        for (int i = 0; i < parts.length; i += 2) {
            int startMinute = dayToMinutes.get(parts[i]) + parseMinutes(parts[i + 1]);
            int endMinute = startMinute + (parts.length == 2 ? 180 : 90);  // 3 hours if one session, 1.5 hours if two
            times[i] = startMinute;
            times[i + 1] = endMinute;
        }
        return times;
    }

    private int parseMinutes(String time) {
        String[] hm = time.split(":");
        return Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
    }

    private int countValidSchedules(List<List<int[]>> courses, int index, List<int[]> current) {
        if (index == courses.size()) {
            return checkNoOverlap(current) ? 1 : 0;
        }
        int count = 0;
        for (int[] slot : courses.get(index)) {
            current.add(slot);
            count += countValidSchedules(courses, index + 1, current);
            current.remove(current.size() - 1);
        }
        return count;
    }

    private boolean checkNoOverlap(List<int[]> schedule) {
        for (int i = 0; i < schedule.size(); i++) {
            for (int j = i + 1; j < schedule.size(); j++) {
                if (overlaps(schedule.get(i), schedule.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean overlaps(int[] a, int[] b) {
        for (int i = 0; i < a.length; i += 2) {
            for (int j = 0; j < b.length; j += 2) {
                if (!(a[i + 1] <= b[j] || a[i] >= b[j + 1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Test02 solution = new Test02();
        String[][] schedule = {
//                {"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"},
//                {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"},
//                {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"},
//                {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"},
//                {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}

                {"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"},
                {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"},
                {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"},
                {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"},
                {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}

        };
        System.out.println(solution.solution(schedule));  // 출력해야 할 값: 896
    }


}
