#include <vector>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int p0=0,p2=nums.size()-1;
        int p=0;
        while(p<=p2){
            if(nums[p]==0){
                swap(nums[p0++],nums[p++]);
            }else if(nums[p]==2){
                swap(nums[p],nums[p2--]);
            }else{
                p++;
            }
        }
    }
};
