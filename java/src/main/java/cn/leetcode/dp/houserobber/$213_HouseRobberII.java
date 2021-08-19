package cn.leetcode.dp.houserobber;

public class $213_HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        System.arraycopy(nums, 0, nums1, 0, nums1.length);
        System.arraycopy(nums, 1, nums2, 0, nums2.length);
        return Math.max(robRange(nums1), robRange(nums2));
    }

    public int robRange(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int[] f = new int[n];
        f[0] = nums[0];
        f[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        int res = new $213_HouseRobberII().rob(new int[]{1, 2, 3, 1});
        System.out.println(res);
    }
}
