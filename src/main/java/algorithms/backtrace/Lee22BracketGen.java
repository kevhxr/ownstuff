package algorithms.backtrace;

import java.util.ArrayList;
import java.util.List;

public class Lee22BracketGen {

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.stream().forEach(str-> System.out.println(str));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        if(n == 0){
            return result;
        }
        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;

    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
