#include <vector>
#include <algorithm>

using namespace std;


class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> path;
        vector<int> flag(nums.size(),false);
        // 排序
        sort(nums.begin(),nums.end());
        dfs(0,nums,path,res,flag);
        return res;
    }

    void dfs(int depth,vector<int>& nums,vector<int>& path,vector<vector<int>>& res,vector<int>& flag){
        if(depth==nums.size()){
            res.push_back(path);
            return;
        }

        for(int i=0;i<nums.size();i++){
            // 剪枝
            if(flag[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !flag[i-1]) continue;

            flag[i]=true;
            path.push_back(nums[i]);
            dfs(depth+1,nums,path,res,flag);
            flag[i]=false;
            path.pop_back();
        }
    }
};
