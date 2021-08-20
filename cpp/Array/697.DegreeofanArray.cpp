class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        int res=0,degree=0;
        unordered_map<int,int> first,count;

        for(int i=0;i<nums.size();i++){
            if(first.count(nums[i])==0) first[nums[i]]=i;
            if(++count[nums[i]]>degree){
                degree=count[nums[i]];
                res=i-first[nums[i]]+1;
            }else if(count[nums[i]]==degree){
                res=min(res,i-first[nums[i]]+1);
            }
        }
        return res;
    }
};
