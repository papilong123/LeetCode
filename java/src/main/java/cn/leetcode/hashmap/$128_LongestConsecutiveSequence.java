package cn.leetcode.hashmap;

import java.util.HashSet;

public class $128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int j : nums) {
            set.add(j);
        }
        int ans = 0;

        for (int num : nums) {
            int curlen = 1;
            if (!set.contains(num - 1)) {
                int curnum = num;

                while (set.contains(curnum + 1)) {
                    curnum++;
                    curlen++;
                }
            }
            ans = Math.max(ans, curlen);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new $128_LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println(ans);
    }
}
