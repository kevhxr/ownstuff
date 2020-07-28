package corejava.core.container;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String,String> map = new LinkedHashMap<>();

        map.put("ddd","ssss");
        String dd = map.getOrDefault("dd","not found");
        System.out.println(dd);
    }

    @Test
    public void swapTest(){
        int first = 0;
        for (int i = first; i <2 ; i++) {
            System.out.println(i+" "+first);
        }
        ArrayList<Integer> output = new ArrayList<>();
        output.add(1);
        output.add(2);
        output.add(3);
        Collections.swap(output, 0, 0);
        output.stream().forEach(a-> System.out.print(a+","));
    }
}
