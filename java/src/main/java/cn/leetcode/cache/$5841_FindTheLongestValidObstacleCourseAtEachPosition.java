package cn.leetcode.cache;

import java.util.ArrayList;
import java.util.List;

public class $5841_FindTheLongestValidObstacleCourseAtEachPosition {
    List<Integer> stack;
    int[] ans;
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        ans = new int[n];
        stack = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(stack.size() == 0 || stack.get(stack.size()-1) <= obstacles[i]){ //空或者当前值大于栈顶元素
                stack.add(obstacles[i]);
                ans[i] = stack.size();
            }
            else{
                int idx = binarySearch(obstacles[i]);
                stack.set(idx, obstacles[i]);
                ans[i] = ++idx;
            }
        }
        return ans;
    }

    public int binarySearch(int target){
        int l = 0, r = stack.size() - 1;
        while(l < r){
            int mid = (l + r) >> 1;
            if(stack.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1};
        int[] ans = new $5841_FindTheLongestValidObstacleCourseAtEachPosition().longestObstacleCourseAtEachPosition(arr);
        System.out.println();
    }

}
