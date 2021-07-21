class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int res=INT_MIN;
        int cn.example.dp(nums[0]);
        res=cn.example.dp;

        for(int i=1;i<nums.size();i++){
            cn.example.dp=max(cn.example.dp+nums[i],nums[i]);
            res=max(res,cn.example.dp);
        }
        return res;
    }
};
