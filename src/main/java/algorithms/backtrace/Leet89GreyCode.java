package algorithms.backtrace;

import java.util.ArrayList;
import java.util.LinkedList;

public class Leet89GreyCode {

    public static void main(String[] args) {
        String aab = "1234";
        System.out.println(aab.substring(0,2));
        System.out.println();
        LinkedList aaa = new LinkedList<Integer>();
        aaa.add(1);
        aaa.add(2);
        aaa.add(3);
        System.out.println(aaa.poll());
        System.out.println(aaa.poll());
        System.out.println();

        // 1 ^ 1 = 0
        // 1 ^ 0 = 1
        // 0 ^ 0 = 0
        // 0 ^ 1 = 1
        int n = 3;

        ArrayList<Integer> res = new ArrayList<>();
        int num = 1 << n;
        for (int i = 0; i < num; i++) {
            res.add(i >> 1 ^ i);
        }
        res.stream().forEach(a -> System.out.println(a));
    }
}
