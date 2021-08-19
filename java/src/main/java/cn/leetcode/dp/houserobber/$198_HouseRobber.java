package cn.leetcode.dp.houserobber;

class $198_HouseRobber {
    public int rob(int[] nums) {
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
        int res = new $198_HouseRobber().rob(new int[]{1, 2, 3, 1});
        System.out.println(res);
    }
}
