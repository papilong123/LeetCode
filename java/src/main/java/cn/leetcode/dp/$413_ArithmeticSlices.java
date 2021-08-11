package cn.leetcode.dp;

public class $413_ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                ans += dp[i];
            }
        }
        return ans;
    }

    public int numberOfArithmeticSlices1(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int ans = 0;
        int t = 0;
        int d = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == d) {
                t++;
            } else {
                d = nums[i] - nums[i - 1];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new $413_ArithmeticSlices().numberOfArithmeticSlices1(new int[]{1, 2, 3, 8, 9, 10});
        System.out.println(ans);
    }
}
