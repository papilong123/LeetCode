class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int n=nums.size();
        if(n<=2) return n;
        int sp=1;
        for(int fp=2;fp<n;fp++){
            if(nums[sp-1]!=nums[fp]){
                nums[++sp]=nums[fp];
            }
        }
        return sp+1;
    }
};
