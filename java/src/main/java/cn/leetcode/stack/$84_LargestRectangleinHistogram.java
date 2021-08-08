package cn.leetcode.stack;

import java.util.Stack;

class $84_LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int res=0;
        stack.push(-1);
        for(int i=0;i<heights.length;i++){
            while(stack.peek()!=-1 && heights[stack.peek()]>=heights[i])
                res=Math.max(res , heights[stack.pop()] * (i-stack.peek()-1));
            stack.push(i);
        }

        while(stack.peek()!=-1)
            res=Math.max(res , heights[stack.pop()] * (heights.length-stack.peek()-1));

        return res;
    }
}
