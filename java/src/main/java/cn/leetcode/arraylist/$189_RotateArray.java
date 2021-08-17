package cn.leetcode.arraylist;

class $189_RotateArray {
    public void reverse(int[] nums, int a, int b){
        while(a<b){
            int tmp=nums[b];
            nums[b]=nums[a];
            nums[a]=tmp;
            a++;
            b--;
        }
    }


    public void rotate(int[] nums, int k) {
        k%=nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
}
