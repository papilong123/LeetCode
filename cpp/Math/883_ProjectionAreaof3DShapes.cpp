#include <vector>

using namespace std;

class Solution {
public:
    int projectionArea(vector<vector<int>>& grid) {
        int res=0;
        for(int i=0;i<grid.size();i++){
            int maxr=0,maxc=0;
            for(int j=0;j<grid.size();j++){
                if(grid[i][j]>0){
                    res+=1;
                }
                maxr=max(maxr,grid[i][j]);
                maxc=max(maxc,grid[j][i]);
            }
            res+=maxc+maxr;
        }
        return res;
    }
};
