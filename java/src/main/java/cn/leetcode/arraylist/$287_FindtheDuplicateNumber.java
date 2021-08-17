package cn.leetcode.arraylist;

import java.util.HashSet;
import java.util.Set;

class $287_FindtheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }
}
