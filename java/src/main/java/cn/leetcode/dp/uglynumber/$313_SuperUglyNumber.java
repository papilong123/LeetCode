package cn.leetcode.dp.uglynumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class $313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;
            for (int j = 0; j < m; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }

    // 小顶堆
    public int nthSuperUglyNumber1(int n, int[] primes) {
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        seen.add(1L);
        pq.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long cur = pq.poll();
            ugly = (int) cur;
            for (int prime : primes) {
                long next = cur * prime;
                if (seen.add(next)) {
                    pq.offer(next);
                }
            }
        }
        return ugly;
    }
}
