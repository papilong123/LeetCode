package cn.leetcode.arraylist;

class $35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length-1,i=0;
        while(i<=n){
            int mid=(i+n) >>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                n=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;
    }
}
