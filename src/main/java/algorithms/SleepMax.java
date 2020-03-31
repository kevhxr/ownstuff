package algorithms;

import java.util.*;

public class SleepMax {

    public static void main(String[] args) {
        String schedule = "Mon 01:00-23:00\n" +
                "Tue 01:00-23:00\n" +
                "Wed 01:00-23:00\n" +
                "Thu 01:00-23:00\n" +
                "Fri 01:00-23:00\n" +
                "Sat 01:00-23:00\n" +
                "Sun 01:00-21:00";
        String schedule2 = "Sun 10:00-20:00\n" +
                "Fri 05:00-10:00\n" +
                "Fri 16:30-23:50\n" +
                "Sat 10:00-24:00\n" +
                "Sun 01:00-04:00\n" +
                "Sat 02:00-06:00\n" +
                "Tue 03:30-18:15\n" +
                "Tue 19:00-20:00\n" +
                "Wed 15:14-22:40\n" +
                "Wed 04:25-15:14\n" +
                "Thu 00:00-23:59\n" +
                "Mon 05:00-13:00\n" +
                "Mon 15:00-21:00\n";
        String schedule3 = "Mon 01:00-23:00\n" +
                "Tue 01:00-23:00\n" +
                "Wed 01:00-02:00\n" +
                "Wed 05:00-07:00\n" +
                "Wed 07:00-13:00\n" +
                "Wed 21:00-23:00\n" +
                "Thu 01:00-23:00\n" +
                "Fri 01:00-23:00\n" +
                "Sat 01:00-23:00\n" +
                "Sun 01:00-21:00";
        System.out.println("==================");
        countTime2(schedule2);
    }

    public static void countTime2(String str) {
        String[] split = str.split("\n");
        Map<Integer, List<int[]>> dayMap = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            String[] s = split[i].split(" ");
            int day = getDayNum(s[0]);
            int[] interval = getMinute(s[1].split("-"));
            List<int[]> intervalList = dayMap.get(day) != null
                    ? dayMap.get(day) : new ArrayList<>();
            intervalList.add(new int[]{interval[0], interval[1]});
            dayMap.put(day, intervalList);
        }

        int maxSum = 0;
        int lastEnd = 0;
        for (int i = 0; i < 7; i++) {
            List<int[]> periods = dayMap.get(i);
            periods.sort(Comparator.comparingInt(o -> o[0]));
            int tail = periods.size() - 1;
            int maxStart = periods.get(0)[0] + lastEnd;
            int maxMid = 0;
            lastEnd = 24 * 60 - periods.get(tail)[1];
            for (int j = 0; j < tail; j++) {
                if (j + 1 < tail) {
                    maxMid = Math.max(maxMid, periods.get(j + 1)[0] - periods.get(j)[1]);
                } else {
                    maxMid = Math.max(maxMid, periods.get(tail)[0] - periods.get(j)[1]);
                }
            }
            maxSum = Math.max(maxSum, Math.max(Math.max(maxStart, maxMid), lastEnd));
            System.out.println(i + ": " + maxStart + " " + maxMid + " " + lastEnd);
        }
        System.out.println(maxSum);
        System.out.println("===================");
        dayMap.entrySet().forEach(map -> {
            System.out.print(map.getKey() + ":");
            map.getValue().stream().forEach(pp -> {
                System.out.print("{" + pp[0] + "," + pp[1] + "}" + " ");
            });
            System.out.println();
        });
    }

    public static int[] getMinute(String[] interval) {
        String[] start = interval[0].split(":");
        String[] end = interval[1].split(":");
        int[] startEnd = new int[2];
        startEnd[0] = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        startEnd[1] = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        return startEnd;
    }

    public static int getDayNum(String day) {
        switch (day) {
            case "Mon":
                return 0;
            case "Tue":
                return 1;
            case "Wed":
                return 2;
            case "Thu":
                return 3;
            case "Fri":
                return 4;
            case "Sat":
                return 5;
            case "Sun":
                return 6;
        }
        return 0;
    }

}