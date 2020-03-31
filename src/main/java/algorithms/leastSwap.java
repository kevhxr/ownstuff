package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class leastSwap {

    public static void main(String[] args) {
        Map<Integer,Integer> map = new ConcurrentHashMap<Integer,Integer>();
        System.out.println(10>>1);
        int[] arr = {1,5,3,3,7};
        doget(arr);
    }

    public static void doget(int[] arr){
        int swapNum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
                swapNum++;
            }
        }
        System.out.println(swapNum);
    }
}
