#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {
        int res=0,count=1;
        if(nums.size()==0) return 0;
        else if(nums.size()==1) return 1;
        for(int i=0;i<nums.size()-1;i++){
            if(nums[i]<nums[i+1]) count++;
            else{
                res=max(res,count);
                count=1;
            }
        }
        res=max(res,count);
        return res;
    }
};
