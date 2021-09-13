#include <vector>

using namespace std;

class Solution {
public:
    int jump(vector<int>& nums) {
        int n=nums.size();

        int step=0;
        int maxlength=0;
        int end=0;
        
        //最后一个不用检测，如果监测的话会产生多余的一步，所以i<n-1
        for(int i=0;i<n-1;i++){
            maxlength=max(maxlength,i+nums[i]);
            if(i==end){
                step++;
                end=maxlength;
            }
        }
        return step;
    }
};
