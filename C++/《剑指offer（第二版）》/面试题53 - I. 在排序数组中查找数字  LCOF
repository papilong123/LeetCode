class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size()==0) return 0;
        int mid=helper(nums,target);
        if(mid<0) return 0;
        int i=mid,j=mid;
        while(i>=0 && nums[mid]==nums[i]) --i;
        while(j<nums.size() && nums[mid]==nums[j]) ++j;
        return j-i-1;
    }

    int helper(vector<int>& nums,int target){
        int i=0,j=nums.size()-1;
        while(i+1<j){
            int mid=i+(j-i)/2;
            if(nums[mid]<target){
                i=mid;
            }else if(nums[mid]>target){
                j=mid;
            }else{
                return mid;
            }
        }
        if(nums[i]==target) return i;
        if(nums[j]==target) return j;
        return -1;
    }
};
