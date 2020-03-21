class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int candidate=nums[0],cnt=1;
        for(int i=1;i<nums.size();i++){
            if(candidate==nums[i]){
                ++cnt;
            }else{
                if(cnt==0){
                    candidate=nums[i];
                    cnt=1;
                }else{
                    --cnt;
                }
            }
        }
        cnt=0;
        for(int i=0;i<nums.size();++i){
            if(nums[i]==candidate) ++cnt;
        }
        if(cnt>nums.size()/2) return candidate;
        return -1;
    }
};
