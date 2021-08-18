package cn.leetcode.dp;

public class $45_JumpGameII {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        
        for (int i = 1, j = 0; i < n; i++) {
            while (j + nums[j] < i) j++;
            f[i] = f[j] + 1;
        }
        return f[n - 1];
    }
}
