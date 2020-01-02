class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res=INT_MIN;
        int dp(nums[0]);
        res=dp;

        for(int i=1;i<nums.size();i++){
            dp=max(dp+nums[i],nums[i]);
            res=max(res,dp);
        }
        return res;
    }
};
