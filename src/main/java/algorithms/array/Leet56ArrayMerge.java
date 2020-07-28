package algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leet56ArrayMerge {

    public static void main(String[] args) {
        List<Integer> aa = new ArrayList<>();
        int a = 1;
        int b = 1;
        System.out.println(++a);
        System.out.println(b++);
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = selfmerge(intervals);
        Arrays.stream(merge).forEach(arr -> System.out.print("(" + arr[0] + " " + arr[1] + ")"));
    }

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        Arrays.stream(intervals).forEach(arr -> System.out.print("(" + arr[0] + " " + arr[1] + ")"));
        System.out.println();
        System.out.println();
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
                System.out.println(idx);
                Arrays.stream(res).forEach(arr -> System.out.print("(" + arr[0] + " " + arr[1] + ")"));
                System.out.println();
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }


    public static int[][] selfmerge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(v -> v[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || res[idx][1] < interval[0]) {
                res[++idx] = interval;
            }else{
                res[idx][1] = Math.max(res[idx][1],interval[1]);
            }
        }
        System.out.println(idx);
        return Arrays.copyOf(res,idx+1);
    }
}
