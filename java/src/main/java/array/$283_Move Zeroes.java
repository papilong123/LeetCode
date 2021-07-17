package array;

class Solution {
    public void moveZeroes(int[] nums) {
        for(int i=0,j=-1;i<nums.length;i++){
            if(nums[i]!=0){
                j++;
                int tmp=nums[j];
                nums[j]=nums[i];
                nums[i]=tmp;
            }
        }
    }
}
