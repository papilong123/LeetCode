#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> bias={{0,1},{1,0},{0,-1},{-1,0}};
    int res=0;

    int getMaximumGold(vector<vector<int>>& grid) {
        int row=grid.size(),col= row==0?0:grid[0].size();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]>0){
                    dfs(i,j,0,row,col,grid);
                }
            }
        }

        return res;
    }

    bool isArea(int i,int j,int row,int col,vector<vector<int>>& grid){
        if(i<0||i>row-1 || j<0||j>col-1 || grid[i][j]==0) return false;
        return true;
    }

    void dfs(int i,int j,int cur,int row,int col,vector<vector<int>>& grid){
        cur+=grid[i][j];
        res=max(res,cur);
        int tmp=grid[i][j];
        grid[i][j]=0;
        for(int k=0;k<4;k++){
            if(isArea(i+bias[k][0],j+bias[k][1],row,col,grid)){
                dfs(i+bias[k][0],j+bias[k][1],cur,row,col,grid);
            }
        }
        grid[i][j]=tmp;
    }
};
