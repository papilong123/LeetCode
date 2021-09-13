#include <vector>
using namespace std;

class Solution {
public:
    int dominantIndex(vector<int>& nums) {
        if(nums.size()==0) return -1;
        if(nums.size()==1) return 0;

        int pre=nums[1],p=nums[0];         //前后两元素分别在0，1为标记的位置上
        int index=0;

        for(int i=1 ; i<nums.size() ; i++){
            if(nums[i]>=p){
                pre=p;
                p=nums[i];
                index=i;
            }else if(nums[i]>pre){
                pre=nums[i];
            }
        }

        if( p >= 2*pre ) return index;
        return -1;
    }
};
