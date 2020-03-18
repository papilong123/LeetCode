class Solution {
public:
    vector<int> exchange(vector<int>& nums) {
        int i=0,j=nums.size()-1;
        while(i<j){
            if((nums[i]&1)==1){
                ++i;
                continue;
            }
            if((nums[j]&1)==0){
                --j;
                continue;
            }
            swap(nums[i],nums[j]);
        }
        return nums;
    }
};
