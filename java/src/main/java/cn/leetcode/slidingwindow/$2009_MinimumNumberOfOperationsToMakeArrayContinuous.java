package cn.leetcode.slidingwindow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class $2009_MinimumNumberOfOperationsToMakeArrayContinuous {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> us = new HashSet<>();
        for (int x : nums)
            us.add(x);

        int an = us.size();
        int[] a = new int[an];
        int i = 0;
        for (int x : us)
            a[i++] = x;

        Arrays.sort(a);

        int cur = 0;
        int r = 0;
        for (int l = 0; l < an; l++) {
            while (r + 1 < an && a[r + 1] - a[l] <= n - 1)
                r++;
            cur = Math.max(cur, r - l + 1);
        }

        return n - cur;
    }
}
