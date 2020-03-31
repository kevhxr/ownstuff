package algorithms;

import java.util.*;

public class amplitudeTest {

    public static void main(String[] args) {
        List<Integer> sub = new ArrayList<>();
        sub.add(1);
        sub.add(1);
        sub.add(3);
        sub.add(2);
        sub.get(sub.size() - 1);

        System.out.println("======");

        int[] a = {1,6,7,8,9,9,10};
        algo(a);
    }

    public static void algo(int[] a) {
        Arrays.sort(a);
        Arrays.stream(a).forEach(s -> System.out.print(s + ","));
        Map<Integer, Integer> posMap = new HashMap<>();
        int curLen = 1;
        int maxLen = 1;
        int min = a[0];
        int max = a[0];
        posMap.put(min, 0);

        for (int i = 1; i <= a.length - 1; i++) {
            if (Math.abs(a[i] - min) <= 1) {
                max = a[i];
                if (posMap.get(a[i]) == null) {
                    posMap.put(a[i], i);
                }
                curLen++;
                maxLen = maxLen > curLen ? maxLen : curLen;
            } else {
                if (Math.abs(a[i] - max) <= 1) {
                    min = max;
                    i = posMap.get(max);
                    curLen = 1;
                } else {
                    min = a[i];
                    curLen = 1;
                }
            }
        }
        System.out.println();
        System.out.println("============");
        System.out.println();
        System.out.println(maxLen);
    }
}
