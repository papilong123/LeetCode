package cn.leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class $6_ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();
        List<StringBuilder> arr = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            arr.add(new StringBuilder());
        }
        int flag = -1;
        int i = 0;
        for (char c : s.toCharArray()) {
            arr.get(i).append(c);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        for (StringBuilder sb :
                arr) {
            ans.append(sb);
        }
        return ans.toString();
    }
}
