package algorithms.collection;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class SimpleStackLeet739 {

    public static void main(String[] args) {
        System.out.println(20%10);
        int[] nums = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(nums);
        Arrays.stream(ans).forEach(a-> System.out.print(a+","));
    }

    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();

        IntStream.rangeClosed(0, ans.length-1).boxed()
                .forEach(i->{
                    int temp = T[i];
                    while(!stack.isEmpty() && temp > T[stack.peek()]){
                        int preIndex = stack.pop();
                        ans[preIndex] = i-preIndex;
                    }
                    stack.push(i);
                });


/*        for(int i=0;i<length;i++){
            int temp = T[i];
            while(!stack.isEmpty() && temp > T[stack.peek()]){
                int preIndex = stack.pop();
                ans[preIndex] = i-preIndex;
            }
            stack.push(i);
        }*/
        return ans;
    }
}
