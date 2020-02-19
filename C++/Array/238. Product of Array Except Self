class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> res(nums.size(),1);
        int left=1,right=1;
        for(int i=0;i<nums.size();i++){
            res[i]*=left;
            left*=nums[i];
        }
        for(int i=nums.size()-1;i>=0;i--){
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
};
