package algorithms.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Leet179MaxNum {

    static class LargerNumberComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            System.out.println(a+" "+b);
            String order1 = a + b;
            String order2 = b + a;
            System.out.println(order1 + " " + order2 + " " + order2.compareTo(order1));
            return order2.compareTo(order1);
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1,2,32,14,5};
        String[] strs = {"11","ff"};

        String aa = "sdads";
        String[] split = aa.split("");


        Arrays.stream(strs).map(a->a+"sss").collect(Collectors.toList()).stream().forEach(a->{
            System.out.print(a+",");
        });
        System.out.println();
        System.out.println();
        List<String> collect = Arrays.stream(nums)
                .map(Object::toString)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.toList());

        collect.stream().forEach(a-> System.out.print(a+" "));
        //largestNumber(nums);
    }

    public static String largestNumber(int[] nums) {
        // Get input integers as strings.
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.stream(asStrs).forEach(a -> System.out.print(a + ","));
        System.out.println();
        System.out.println();
        // Sort strings according to custom comparator.
        Arrays.sort(asStrs, new LargerNumberComparator());

        System.out.println();
        System.out.println();
        Arrays.stream(asStrs).forEach(a -> System.out.print(a + ","));

        // If, after being sorted, the largest number is `0`, the entire number
        // is zero.
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // Build largest number from sorted array.
        String largestNumberStr = new String();
        for (String numAsStr : asStrs) {
            largestNumberStr += numAsStr;
        }

        System.out.println();
        System.out.println();
        System.out.println(largestNumberStr);
        return largestNumberStr;
    }
}
