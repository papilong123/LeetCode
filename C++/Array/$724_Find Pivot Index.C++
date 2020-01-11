class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int leftsum=0,sum=0;
        int k=0;
        while(k<nums.size()){
            sum+=nums[k++];
        }
        for(int i=0;i<nums.size();i++){
            if(sum-nums[i]-leftsum==leftsum)
            return i;
            leftsum+=nums[i];
        }
        return -1;
    }
};
