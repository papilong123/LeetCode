package cn.leetcode.array;

public class Nums {
    // 209. 长度最小的子数组,找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度
    // 划动窗口
    public int minimumSizeSubarraySum(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            end++;
            while (sum >= s) {
                ans = Math.min(ans, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
