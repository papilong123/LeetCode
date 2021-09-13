#include <vector>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        int i=0,j=nums.size()-1;
        while(i<j){
            int mid=(j+i)/2;
            if(nums[mid]>nums[j]){
                i=mid+1;
            }else if(nums[mid]<nums[j]){
                j=mid;
            }else{
                j--;
            }
        }
        return nums[i];
    }
};
