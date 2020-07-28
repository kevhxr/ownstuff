package algorithms.array;

import java.util.Arrays;

public class Leet1300cloestArrVal {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        int i = Arrays.binarySearch(arr, 4);
        int i2 = Arrays.binarySearch(arr, 5);
        int i3 = Arrays.binarySearch(arr, 6);
        int i4 = Arrays.binarySearch(arr, 16);
        System.out.println(arr.length);
        System.out.println(i + " " + i2);
        System.out.println(i3 + " " + i4);
        int[] arr2 = {48772,52931,14253,32289,75263};
        int bestValue = findBestValue(arr2, 40876);
        System.out.println(bestValue);
    }


    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = arr[i - 1] + prefix[i - 1];
        }
        int ans = -1;
        int left = 0;
        int right = arr[n - 1];

        while (left <= right) {
            int mid = (right + left) / 2;
            int tempIndex = Arrays.binarySearch(arr, mid);
            if (tempIndex < 0) {
                tempIndex = -tempIndex - 1;
            }
            int cur = prefix[tempIndex] + (n - tempIndex) * mid;
            if (cur <= target) {
                left = mid+1;
            } else {
                ans = mid;
                right = mid -1;
            }
        }

        int chooseSmall = check(arr, ans);
        int chooseBig = check(arr, ans + 1);
        System.out.println(chooseSmall+" "+chooseBig+" "+ans);
        return Math.abs(chooseSmall - target) <= Math.abs(chooseBig - target) ? ans-1 : ans;
    }

    private static int check(int[] arr, int ans) {
        int res = 0;
        for (int num : arr) {
            res += Math.min(num, ans);
        }
        return res;
    }


}
