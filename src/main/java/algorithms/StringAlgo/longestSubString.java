package algorithms.StringAlgo;

import java.util.HashSet;
import java.util.Set;

public class longestSubString {


    public static void main(String[] args) {
        System.out.println(10*10+('1'-'0'));
        lengthOfLongestSubstring("abbabc");
    }

    public static int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, ans = 0;
        Set<Character> set = new HashSet<>();
        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end++));
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(start++));
            }
        }
        return ans;
    }
}
