package cn.leetcode.dp.LIS;

import java.util.Arrays;

public class $300_LongestIncreasingSubsequence {

    // dp + 二分 最快解法 O(nlog(n))
    public  int lengthOfLIS(int[] nums){
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[len] = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] > dp[len]) {
                dp[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0; // 如果找不到说明所有的数都比 nums[i] 大，此时要更新 dp[1]，所以这里将 pos 设为 0
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (dp[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }

    // dp O(n^2)
    public int lengthOfLIS1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int ans = new $300_LongestIncreasingSubsequence().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
        System.out.println(ans);
    }
}
