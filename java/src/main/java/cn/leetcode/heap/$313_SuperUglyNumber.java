package cn.leetcode.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class $313_SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
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
