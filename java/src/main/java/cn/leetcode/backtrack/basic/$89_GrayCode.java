package cn.leetcode.backtrack.basic;

import java.util.ArrayList;
import java.util.List;

public class $89_GrayCode {
    List<Integer> res = new ArrayList<>();

    public List<Integer> grayCode(int n) {
        backtrace(n, new StringBuffer(), new int[]{0, 1});
        return res;
    }

    private void backtrace(int n, StringBuffer sb, int[] nums) {
        //判断条件，是否返回
        if (sb.length() == n) {
            // 二进制转换为十进制
            res.add(Integer.valueOf(sb.toString(), 2));
            return;
        }
        // 回溯第一个状态
        sb.append(nums[0]);
        //注意数组
        backtrace(n, sb, new int[]{0, 1});
        sb.deleteCharAt(sb.length() - 1);
        // 回溯第二个状态
        sb.append(nums[1]);
        //注意数组
        backtrace(n, sb, new int[]{1, 0});
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<Integer> grayCodeEasy(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

}
