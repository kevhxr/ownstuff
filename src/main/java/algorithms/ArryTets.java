package algorithms;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class ArryTets {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(1);
        queue.add(2);
        System.out.println(queue.poll());
        List<int[]> a = new ArrayList<>();
        a.add(new int[]{600,700});
        a.add(new int[]{900,1100});
        a.add(new int[]{1200,1300});
        a.add(new int[]{800,900});
        a.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        a.stream().forEach(aa->{
            System.out.println();
            Arrays.stream(aa).forEach(aaa-> System.out.print(aaa+" "));
        });
    }
}


/*
    public static void countTime(String str) {
        int[] max = new int[7];
        String[] split = str.split("\n");
        Arrays.stream(split).forEach(s -> System.out.println(s));
        Map<Integer, Map<String, Integer>> dayMap = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            String[] s = split[i].split(" ");
            int[] interval = getMinute(s[1].split("-"));
            int day = getDayNum(s[0]);

            Map<String, Integer> dayDetail = new HashMap<>();
            if (dayMap.get(day) == null) {
                dayDetail.put("start", interval[0]);
                dayDetail.put("end", interval[1]);
                dayDetail.put("midMax", 0);
            } else {
                dayDetail = adjustDayDetail(dayMap, day, interval);
            }
            dayMap.put(day, dayDetail);

            if (day != 0 && day != 6) {
                max[day] = updateMaxInterval(dayMap, day, dayMap.get(day));
                max[day - 1] = updateMaxInterval(dayMap, day - 1, dayMap.get(day - 1));
                max[day + 1] = updateMaxInterval(dayMap, day + 1, dayMap.get(day + 1));
            } else {
                int nightDay = dayDetail.get("start");
                int dayNight = 24 * 60 - dayDetail.get("end");
                max[day] = Math.max(Math.max(nightDay, dayDetail.get("midMax")), dayNight);
                dayDetail.put("max", max[day]);
                if (day == 0) {
                    max[day + 1] = updateMaxInterval(dayMap, day + 1, dayMap.get(day + 1));
                } else {
                    max[day - 1] = updateMaxInterval(dayMap, day - 1, dayMap.get(day - 1));
                }
            }
        }
        dayMap.entrySet().stream().forEach(sm -> System.out.println(sm.getKey() + 1 + " : " + sm.getValue().get("start")
                + " , " + sm.getValue().get("midMax")
                + " , " + sm.getValue().get("end")
                + " , " + sm.getValue().get("max")));
        System.out.println("--------------------------");

        Arrays.sort(max);
        System.out.println(max[max.length - 1]);
    }

    public static Map<String, Integer> adjustDayDetail(Map<Integer, Map<String, Integer>> dayMap, int day, int[] interval) {
        Map<String, Integer> dayDetail = dayMap.get(day);
        if (dayDetail.get("start") >= interval[1]) {
            //new interval on right side
            dayDetail.put("midMax", dayDetail.get("start") - interval[1]);
            dayDetail.put("start", interval[0]);

        } else if (dayDetail.get("end") <= interval[0]) {
            //new interval on left side
            dayDetail.put("midMax", interval[0] - dayDetail.get("end"));
            dayDetail.put("end", interval[1]);
        }
        return dayDetail;

    }

    public static int updateMaxInterval(Map<Integer, Map<String, Integer>> dayMap, int day, Map<String, Integer> dayDetail) {
        if (dayDetail == null) {
            return 0;
        }
        Map<String, Integer> preDayDetail = dayMap.get(day - 1);
        Map<String, Integer> postDayDetail = dayMap.get(day + 1);
        int preEnd = preDayDetail != null ? preDayDetail.get("end") : 24 * 60;
        int postStart = postDayDetail != null ? postDayDetail.get("start") : 0;
        int nightDay = 24 * 60 - preEnd + dayDetail.get("start");
        int dayNight = 24 * 60 - dayDetail.get("end") + postStart;
        int max = Math.max(Math.max(nightDay, dayDetail.get("midMax")), dayNight);
        dayDetail.put("max", max);
        dayMap.put(day, dayDetail);
        return max;
    }
*/