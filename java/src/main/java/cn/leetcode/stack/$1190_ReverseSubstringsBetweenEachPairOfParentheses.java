package cn.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class $1190_ReverseSubstringsBetweenEachPairOfParentheses {
    public String reverseParentheses(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(sb.toString());
                sb.setLength(0);
            } else if (s.charAt(i) == ')') {
                sb.reverse();
                sb.insert(0, stack.pop());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
