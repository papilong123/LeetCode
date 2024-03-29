#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int triangleNumber(vector<int>& nums) {
        int res=0,n=nums.size();

        // 排序
        sort(nums.rbegin(),nums.rend());

        // 统计符合条件的三角形个数
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                if(nums[left]+nums[right]<=nums[i]){
                    right--;
                }else{
                    res+=right-left;
                    left++;
                }
            }
        }

        return res;
    }
};
