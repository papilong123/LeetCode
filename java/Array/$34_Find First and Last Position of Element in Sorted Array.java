class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=0,end=nums.length-1,mid=0;
        if((mid=helper(nums,start,end,target))!=-1){
            int pre=mid,post=mid,last_pre=mid,last_post=mid;
            while(pre!=-1){
                last_pre=pre;
                pre=helper(nums,start,pre-1,target);
            }
            while(post!=-1){
                last_post=post;
                post=helper(nums,post+1,end,target);
            }
            return new int[]{last_pre,last_post};
        }else{
            return new int[]{-1,-1};
        }
    }

    //find index
    public int helper(int[] nums,int start,int end,int target){
        while(start<=end){
            int mid=(start+end) >>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
}
