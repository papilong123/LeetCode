package cn.leetcode.bitmanipulation;

public class $287_FindDuplicate {
    public int findDuplicate(int[] nums) {
        return nums.length;
    }

    public static void main(String[] args) {
        int ans = new $287_FindDuplicate().findDuplicate(new int[]{1,3,4,2,2});
        System.out.println(ans);
    }
}
