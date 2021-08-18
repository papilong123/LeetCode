package cn.leetcode.dp.parentheses;

import java.util.ArrayList;
import java.util.List;

public class $22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();

        dp.add(new ArrayList<String>() {{
            add("");
        }});
        for (int i = 1; i <= n; i++) {

            List<String> t = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        t.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(t);
        }
        return dp.get(n);
    }
}
