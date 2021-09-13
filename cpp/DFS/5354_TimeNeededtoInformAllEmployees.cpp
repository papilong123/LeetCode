#include <vector>

using namespace std;

class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        vector<vector<int>> m(n,vector<int>());
        for(int i=0;i<n;i++){
            if(manager[i]==-1) continue;
            m[manager[i]].push_back(i);
        }
        int res=0;
        dfs(headID,informTime,m,0,res);
        return res;
    }
    void dfs(int ID,vector<int>& informTime,vector<vector<int>>& m,int time,int& res){
        if(m[ID].empty()){
            res=max(res,time);
            return;
        }
        time+=informTime[ID];
        for(auto& next:m[ID]){
            dfs(next,informTime,m,time,res);
        }
    }
};


// 需要先将“我的领导是谁”这张数据表转换成“我是领导，我手下有谁谁谁”这样的表
// 这样就可以一层一层往下找了
// 那么用 bfs 还是 dfs
// 考虑到一种情况，0 手下 1 和 2 ， 1 的时间是 2s ，而 2 的时间是 5s 。从此之后再下级的时间就不一样了。
// 使用 bfs 处理上会更麻烦一点
// 所以使用 dfs
