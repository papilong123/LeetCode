class Solution {
    public void nextPermutation(int[] nums) {
        int k=nums.length-2;
        while(k>=0&&nums[k]>=nums[k+1]){
            k--;
        }

        if(k>=0){
            int j=nums.length-1;
            while(j>=k&&nums[j]<=nums[k]){
                j--;
            }
            swap(nums,k,j);
        }
        reverse(nums,k+1);
    }

    public void swap(int[] nums,int k,int j){
        int tmp=nums[k];
        nums[k]=nums[j];
        nums[j]=tmp;
    
    }

    public void reverse(int[] nums, int k){
        int a=k,b=nums.length-1;
        while(a<b){
            swap(nums,a,b);
            a++;
            b--;
        }
    }
}
