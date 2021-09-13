#include <vector>
#include <climits>

using namespace std;
class Solution {
public:
    int minMoves(vector<int>& nums) {
        int res=0;
        int min_val=INT_MAX;
        for(auto num: nums){
            min_val=min(min_val,num);
        }
        for(auto num: nums){
            res+=num-min_val;
        }
        return res;
    }
};
