package cn.leetcode.arraylist;

public class $80_RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) nums[u++] = x;
        }
        return u;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        int ans = new $80_RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums);
        System.out.println(ans);
    }
}
