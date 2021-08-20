package cn.leetcode.dp;

public class $152_MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n][2];
        f[0][0] = nums[0];
        f[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i][0] = Math.max(Math.max(f[i - 1][1] * nums[i], f[i - 1][0] * nums[i]), nums[i]);
            f[i][1] = Math.min(Math.min(f[i - 1][0] * nums[i], f[i - 1][1] * nums[i]), nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, f[i][0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int ans = new $152_MaximumProductSubarray().maxProduct(new int[]{1, 2, -1, -2, 2, 1, -2, 1, 4, -5, 4});
        System.out.println(ans);
    }
}
