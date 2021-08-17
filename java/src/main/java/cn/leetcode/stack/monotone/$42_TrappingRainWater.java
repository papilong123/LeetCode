package cn.leetcode.stack.monotone;

import java.util.Deque;
import java.util.LinkedList;

class $42_TrappingRainWater {
    // 单减栈
    public int trap(int[] height) {
        int ans = 0, n = height.length;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int cur = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i - left - 1;
                int curHeight = Math.min(height[left], height[i]) - height[cur];
                ans += curWidth * curHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
