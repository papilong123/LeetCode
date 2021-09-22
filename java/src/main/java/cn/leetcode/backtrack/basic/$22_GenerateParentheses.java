package cn.leetcode.backtrack.basic;

import java.util.ArrayList;
import java.util.List;

public class $22_GenerateParentheses {
    // 做加法

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }

        dfs("", 0, 0, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号已经用了几个
     * @param right  右括号已经用了几个
     * @param n      左括号、右括号一共得用几个
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {  // 左右括号个数都等于n时加入结果集
            res.add(curStr);
            return;
        }

        // 右括号数量不能大于等于左括号数量
        if (left < right) {
            return;
        }

        if (left < n) {  // 左括号最多有n个
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {  // 右括号最多有n个
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }

}
