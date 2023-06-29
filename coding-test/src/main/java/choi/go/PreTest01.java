package choi.go;

import java.util.*;
import java.util.stream.Collectors;

public class PreTest01 {

    private final static Map<String, Integer> dayOfDateMap = new HashMap<>();
    private final static Map<Integer, Integer> calendarMap = new HashMap<>();

    static {
        dayOfDateMap.put("MON", 1);
        dayOfDateMap.put("TUE", 2);
        dayOfDateMap.put("WED", 3);
        dayOfDateMap.put("THU", 4);
        dayOfDateMap.put("FRI", 5);
        dayOfDateMap.put("SAT", 6);
        dayOfDateMap.put("SUN", 7);

        calendarMap.put(1, 31);
        calendarMap.put(2, 28);
        calendarMap.put(3, 31);
        calendarMap.put(4, 30);
        calendarMap.put(5, 31);
        calendarMap.put(6, 30);
        calendarMap.put(7, 31);
        calendarMap.put(8, 31);
        calendarMap.put(9, 30);
        calendarMap.put(10, 31);
        calendarMap.put(11, 30);
        calendarMap.put(12, 31);
    }

    public static void main(String[] args) {
//        String start_date = "05/04 MON";
//        String end_date = "05/30";
//        String[] login_dates = {"05/26", "05/25", "05/27", "05/10", "05/11", "05/23", "05/22", "05/21", "05/06", "05/09", "05/07", "05/08"};
        String start_date = "05/27 SUN";
        String end_date = "06/16";
        String[] login_dates = {"05/31", "05/30", "06/01", "06/04", "06/07", "06/06", "06/09", "06/08", "06/13", "06/14", "06/10"};

        PreTest01 preTest01 = new PreTest01();
        int solution = preTest01.solution(start_date, end_date, login_dates);
        System.out.println(solution);
    }

    public int solution(String start_date, String end_date, String[] login_dates) {
        int answer = 0;
        int startDateMonth = Integer.parseInt(split(start_date.split(" ")[0])[0]);
        int startDateDay = Integer.parseInt(split(start_date.split(" ")[0])[1]);
        int startDateDayOfWeek = dayOfDateMap.get(start_date.split(" ")[1]);

        List<Date> sortedLoginDates = Arrays.stream(login_dates)
                .map(loginDate -> {
                    int month = Integer.parseInt(split(loginDate)[0]);
                    int day = Integer.parseInt(split(loginDate)[1]);
                    int dayOfWeek = 0;

                    if (month == startDateMonth) {
                        int remain = (day - startDateDay) % 7;
                        dayOfWeek = startDateDayOfWeek + remain;
                    } else {
                        Integer endDay = calendarMap.get(startDateDayOfWeek);
                        int sum = endDay - startDateDay + day;
                        for (int i = startDateMonth + 1; i < month; i++) {
                            sum += calendarMap.get(i);
                        }
                        dayOfWeek = startDateDayOfWeek + (sum % 7);
                    }

                    return new Date(month, day, dayOfWeek);
                })
                .filter(date -> date.getDayOfWeek() != 6 && date.getDayOfWeek() != 7)
                .sorted(Comparator.comparing(Date::getMonth)
                        .thenComparing(Date::getDay))
                .collect(Collectors.toList());

        int index = 1;
        int count = 1;
        int size = sortedLoginDates.size();
        for (int i = 1; i < size; i++) {
            int prevMonth = sortedLoginDates.get(i - 1).getMonth();
            int prevDay = sortedLoginDates.get(i - 1).getDay();

            int loginDateMonth = sortedLoginDates.get(i).getMonth();
            int loginDateDay = sortedLoginDates.get(i).getDay();
            int loginDayOfWeek = sortedLoginDates.get(i).getDayOfWeek();

            System.out.println(loginDateMonth + " " + loginDateDay + " " + loginDayOfWeek);

            if (loginDayOfWeek == 1) {
                index = 3;
            } else {
                index = 1;
            }

            if (prevMonth == loginDateMonth) {
                if (prevDay == loginDateDay - index) {
                    count++;
                } else {
                    answer = Integer.max(answer, count);
                    count = 1;
                }
            }

            if (i == sortedLoginDates.size() - 1) {
                answer = Integer.max(answer, count);
            }

        }

        return answer;
    }

    private String[] split(String s) {
        return s.split("/");
    }

    static class Date {

        private final int month;
        private final int day;
        private final int dayOfWeek;

        public Date(int month, int day, int dayOfWeek) {
            this.month = month;
            this.day = day;
            this.dayOfWeek = dayOfWeek;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        public int getDayOfWeek() {
            return dayOfWeek;
        }

    }

}
