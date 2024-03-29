#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> res;
        vector<int> stk;
        dfs(1,n,k,stk,res);
        return res;
    }

    void dfs(int start,int n,int k,vector<int>& stk,vector<vector<int>>& res){
        if(stk.size()==k){
            res.push_back(stk);
            return;
        }

        for(int i=start;i<=n-(k-stk.size())+1;i++){
            stk.push_back(i);
            dfs(i+1,n,k,stk,res);
            stk.pop_back();
        }
    }
};
