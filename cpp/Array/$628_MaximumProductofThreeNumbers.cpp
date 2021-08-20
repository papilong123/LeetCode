class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        int n=nums.size();
        cn.example.sort(nums.begin(),nums.end());
        int a=INT_MIN,b=INT_MIN;
        if(nums[0]<0&&nums[1]<0){
            a=nums[0]*nums[1]*nums[n-1];
        }
        b=nums[n-1]*nums[n-2]*nums[n-3];
        return max(a,b);
    }
};
