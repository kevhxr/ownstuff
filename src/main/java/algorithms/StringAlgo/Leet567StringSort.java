package algorithms.StringAlgo;

import java.util.Arrays;

public class Leet567StringSort {


    public static void main(String[] args) {
        checkInclusion("dog","ilikegod");
    }


    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }

/*        Arrays.stream(s1map).forEach(a-> System.out.print(a+","));
        System.out.println();*/
        Arrays.stream(s2map).forEach(a-> System.out.print(a+","));

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map)){
                return true;
            }
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
            System.out.println();
            System.out.println();
            Arrays.stream(s2map).forEach(a-> System.out.print(a+","));
        }

        System.out.println();
        System.out.println();
        System.out.println("finally");
/*        Arrays.stream(s1map).forEach(a-> System.out.print(a+","));
        System.out.println();*/
        Arrays.stream(s2map).forEach(a-> System.out.print(a+","));

        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]){
                return false;
            }
        }
        return true;
    }
}
