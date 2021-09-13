#include <vector>

using namespace std;

class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int> res(2);

        vector<int> tmp(nums.size()+1,0);
        for(int num: nums){
            tmp[num]++;
        }

        for(int i=1;i<tmp.size();i++){
            if(tmp[i]==2) res[0]=i;
            if(tmp[i]==0) res[1]=i;
        }

        return res;
    }
};
