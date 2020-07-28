package algorithms.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {11, 12, 6, 8, 13};
        Arrays.stream(arr).forEach(a -> System.out.print(a + ","));
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapSort(arr, i, arr.length);
            System.out.println();
            Arrays.stream(arr).forEach(a -> System.out.print(a + ","));
        }

        System.out.println();
        System.out.println();
        for (int i = arr.length - 1; i > 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapSort(arr, 0, i);
            System.out.print(i+" ");
            Arrays.stream(arr).forEach(a -> System.out.print(a + ","));
            System.out.println();
        }
        System.out.println();
        System.out.println();
        Arrays.stream(arr).forEach(a -> System.out.print(a + ","));
    }


    public static void heapSort(int[] arr, int i, int len) {
        int temp = arr[i];

        for (int k = i * 2 + 1; k < len; k = i * 2 + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) {
                k++;
            }
            if (temp < arr[k]) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }

        arr[i] = temp;
    }
}
