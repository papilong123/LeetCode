package cn.leetcode.stack.parentheses;

import java.util.Deque;
import java.util.LinkedList;

public class $32_LongestValidParentheses {

    public int longestValidParentheses(String s) {
        int start = 0, end = 0, res = 0;
        char[] arr = s.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
//        巧妙利用-1处理第一个节点
//        栈底存放上一个不匹配的最后一位
        stack.addLast(-1);
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
//                    只有在栈不空的时候才统计
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }

    /**
     * 左右括号计数的方法
     */
    public int longestValidParentheses1(String s) {
        int start = 0, end = 0, res = 0;
        char[] arr = s.toCharArray();

        // 先排除左括号数量小于右括号的情况。左括号等于右括号数量，则符合条件，更新最长长度
        // 右的数量大于左时，左右都归零
        // 一句话，相等时统计，不等时归零
        for (int i = 0; i < s.length(); i++){
            if(arr[i] == '('){
                start ++;
            }else {
                end++;
            }

            if(start == end){
                res = Math.max(res, 2*end);
            }else if(start < end){
                start = end = 0;
            }
        }

        start = end = 0;

        for (int i = s.length()-1; i > 0 ; i--){
            if(arr[i] == '('){
                start++;
            }else {
                end++;
            }

            if(start == end){
                res = Math.max(res, 2*end);
            }else if(start > end){
                start = end = 0;
            }
        }

        return res;

    }

//    dp
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

}
