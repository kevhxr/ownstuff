package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MergeSortArr {

    public static void main(String[] args) {
        int[] a = {2,2,3,0,0,0};
        int[] b = {1,1,1};
        //merge(a,3,b,3);
        generate(5);
    }


    public static void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, end = m + n - 1;
        while(i >= 0 && j >= 0) {
            if(A[i] > B[j]) A[end--] = A[i--];
            else A[end--] = B[j--];
        }
        while(j >= 0) {
            A[end--] = B[j--];
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows <= 0) return ans;
        int count = 0;
        while(count < numRows) {
            List<Integer> last = count > 0 ? ans.get(count - 1) : new ArrayList<>();
            List<Integer> tmp = new ArrayList();
            for(int i = 0; i <= count; i++) {
                if(i == 0 || i == count) {
                    tmp.add(1);
                }
                else {
                    tmp.add(last.get(i - 1) + last.get(i));
                }
            }
            ans.add(tmp);
            count++;
        }
        return ans;
    }
}
