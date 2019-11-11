class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans =new ArrayList<>();
        Arrays.sort(nums);

        for(int a=0;a<nums.length-3;a++){
            if(a>0&&nums[a]==nums[a-1]) continue;
            for(int b=a+1;b<nums.length-2;b++){
                if(b>a+1&&nums[b]==nums[b-1]) continue;
                int c=b+1,d=nums.length-1;
                while(c<d){
                    int sum=nums[a]+nums[b]+nums[c]+nums[d];
                    if(sum<target){
                        while(c<d&&nums[c]==nums[++c]);
                    }else if(sum>target){
                        while(c<d&&nums[d]==nums[--d]);;
                    }else{
                        ans.add(new ArrayList<Integer>(Arrays.asList(nums[a],nums[b],nums[c],nums[d])));
                        while(c<d&&nums[c]==nums[++c]);
                        while(c<d&&nums[d]==nums[--d]);
                    }
                }
            }
        }
        return ans;
    }
}
