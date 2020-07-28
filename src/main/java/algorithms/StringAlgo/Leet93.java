package algorithms.StringAlgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leet93 {

    int n;
    String s;
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();

    public static void main(String[] args) {
        Leet93 a = new Leet93();
        a.restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        this.s = s;
        backtrack(-1, 3);
        return output;
    }
    public boolean valid(String segment) {
        int m = segment.length();
        if (m > 3){
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
    }

    public void update_output(int curr_pos) {
        /*
        Append the current list of segments
        to the list of solutions
        */
        String segment = s.substring(curr_pos + 1, n);
        if (valid(segment)) {
            segments.add(segment);
            output.add(String.join(".", segments));
            segments.removeLast();
        }
    }

    public void backtrack(int prev_pos, int dots) {
        int max_pos = Math.min(n - 1, prev_pos + 4);
        for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
            String segment = s.substring(prev_pos + 1, curr_pos + 1);
            if (valid(segment)) {
                segments.add(segment);  // place dot
                if (dots - 1 == 0){
                    update_output(curr_pos);
                } else{
                    backtrack(curr_pos, dots - 1);
                }
                segments.removeLast();
            }
        }
    }
}
