package algorithms.array;

import java.util.Arrays;

public class Leet215Stack {

    public static void main(String[] args) {
        Leet215Stack leet215Stack = new Leet215Stack();
        int[] nums = {3,2,3,1,2,4,5,5,6};
        leet215Stack.findKthLargest(nums,4);
    }

    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        Arrays.stream(nums).forEach(a-> System.out.print(a+","));
        System.out.println();
        System.out.println();
        buildMaxHeap(nums, heapSize);
        Arrays.stream(nums).forEach(a-> System.out.print(a+","));
        System.out.println();
        System.out.println();
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }
    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
            System.out.print(i+":  ");
            Arrays.stream(a).forEach(aa-> System.out.print(aa+","));
            System.out.println();
            System.out.println();
        }
    }
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }
}
