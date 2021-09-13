#include <vector>
using namespace std;

//回溯经典算法

class Solution {
    vector<vector<int>> res;
    vector<int> path;

public:
    vector<vector<int>> combinationSum3(int k, int n) {
        dfs(1 , n , k);
        return res;
    }

    void dfs(int start, int target, int k){
        if(target==0 && k==0){
            res.push_back(path);
            return;
        }
        for(int i=start ; i<10 && target>=0; i++){
            path.push_back(i);
            dfs(i+1,target-i, k-1);
            path.pop_back();
        }
    }
};
