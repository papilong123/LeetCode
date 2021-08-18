package cn.leetcode.stack.monotone;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 反序遍历的单减栈，出栈时保留最大值
 */
public class $456_132Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Deque<Integer> d = new ArrayDeque<>();
        int k = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < k) return true;
            while (!d.isEmpty() && d.peekLast() < nums[i]) {  // 递减栈
                // 事实上，k 的变化也具有单调性，直接使用 k = pollLast() 也是可以的
                k = Math.max(k, d.pollLast());
            }
            d.addLast(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans = new $456_132Pattern().find132pattern(new int[]{3,5,0,3,4});
        System.out.println(ans);
    }
}
