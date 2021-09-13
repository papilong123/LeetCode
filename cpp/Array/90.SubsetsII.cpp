#include <vector>
#include <algorithm>
using namespace std;

class Solution {
    vector<vector<int>> res;
    vector<int> path;
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        helper(0,nums);
        return res;
    }

    void helper(int start, vector<int>& nums){
        res.push_back(path);

        for(int i=start;i<nums.size();i++){
            if(i>start && nums[i]==nums[i-1]) continue;

            path.push_back(nums[i]);
            helper(i+1,nums);
            path.pop_back();
        }
    }
};
