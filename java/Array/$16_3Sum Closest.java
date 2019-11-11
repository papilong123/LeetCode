class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans=nums[0]+nums[1]+nums[2];

        for(int k=0;k<nums.length-2;k++){
            int i=k+1,j=nums.length-1;
            while(i<j){
                int sum=nums[k]+nums[i]+nums[j];
                if(Math.abs(target-sum)<Math.abs(target-ans)){
                    ans=sum;
                }
                if(sum<target){
                    i++;
                }else if(sum>target){
                    j--;
                }else{
                    return ans;
                }
            }
        }
        return ans;
    }
}
