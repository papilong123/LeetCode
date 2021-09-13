#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> matrixReshape(vector<vector<int>>& nums, int r, int c) {
        if( nums.size()*nums[0].size() != r*c) return nums;

        vector<vector<int>> res(r,vector<int>(c,0));
        for(int i=0;i<r*c;i++){
            res[i/c][i%c]=nums[i/nums[0].size()][i%nums[0].size()];
        }
        return res;
    }
};
