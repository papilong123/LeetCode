package cn.leetcode.simulation;

import java.util.Arrays;

public class $1646_GetMaximumInGeneratedArray {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 0; i < n + 1; i++) {
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
            }
            if (i != 0 && 2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
            }
        }
        return Arrays.stream(nums).max().getAsInt();
    }

    public static void main(String[] args) {
        int res = new $1646_GetMaximumInGeneratedArray().getMaximumGenerated(0);
        System.out.println(res);
    }
}
