#include<vector>
#include <algorithm>

using namespace std;

class Solution {
private:
    vector<int> candidates;
    vector<vector<int>> res;
    vector<int> path;

public:

    void dfs(int start, int target){
        if(target==0){
            res.push_back(path);
            return;
        }

        for(int i=start;i<candidates.size() && target>=0;i++){
            //剪枝去除重复
            if(i>start && candidates[i-1]==candidates[i])
            continue;

            path.push_back(candidates[i]);
            //不能用重复元素，i+1
            dfs(i+1, target-candidates[i]);
            path.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(),candidates.end());
        this->candidates=candidates;
        dfs(0,target);
        return res;
    }
};

