#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int arrayPairSum(vector<int>& nums){//数组对为相邻两元素的组合
        int sum=0;
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size();i+=2){
            sum+=nums[i];
        }
        return sum;
    }
};
