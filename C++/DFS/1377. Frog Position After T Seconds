class Solution {
public:
    int target;
    vector<vector<int>> G;
    vector<bool> seen;

    double frogPosition(int n, vector<vector<int>>& edges, int t, int target) {
        if(n==1) return 1.0;//只有一个点时
        this->target = target;
        G=vector<vector<int> >(n + 1);
        seen=vector<bool>(n+1 , false);
        for(auto e: edges){//转化为无向图存储结构
            G[e[0]].push_back(e[1]);
            G[e[1]].push_back(e[0]);
        }
        return dfs(1,t);
    }

    double dfs(int i,int t){//函数返回当前节点往下走的概率值
        if(i!=1 && (G[i].size()==1||t==0)){
            return i==target;
        }
        seen[i]=true;
        double res=0;
        for(auto j:G[i]){
            if(!seen[j]){
                res+=dfs(j,t-1);
            }
        }
        return res/(G[i].size()-(i!=1));
    }
};
