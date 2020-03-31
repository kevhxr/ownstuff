package algorithms.myinter;

import java.util.Arrays;

public class TestONe {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 2};
        int sol = solution(a);
        System.out.println(sol);
    }

    public static int solution(int[] arr) {
        // write your code in Java SE 8
        Arrays.sort(arr);
        boolean hasOne = false;
        int smallest = 1;
        if (arr.length < 1 || arr[arr.length - 1] <= 0) {
            return smallest;
        }
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] <= 0) {
                continue;
            } else if (arr[i] > 0 && i + 1 <= arr.length - 1 && arr[i] + 1 < arr[i + 1]) {
                return hasOne ? arr[i] + 1 : 1;
            } else if (arr[i] == 1) {
                hasOne = true;
            }
        }

        return hasOne ? arr[arr.length - 1] + 1 : 1;
    }
}
