package cn.leetcode.dp;

public class $53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxRes = nums[0];
        for (int num : nums) {
//            如果之前的和小于0，则取当前的值
            pre = Math.max(num + pre, num);
            maxRes = Math.max(maxRes, pre);
        }
        return maxRes;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, -1, 7, 8};
        int ans = new $53_MaximumSubarray().maxSubArray(nums);
        System.out.println(ans);
    }
}
