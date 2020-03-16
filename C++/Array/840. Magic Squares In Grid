class Solution {
public:
    int numMagicSquaresInside(vector<vector<int>>& grid) {
        int r=grid.size(),c=grid[0].size(),res=0;
        for(int i=0;i<r-2;i++){
            for(int j=0;j<c-2;j++){
                res+=judge(grid,i,j);
            }
        }
        return res;
    }

    bool judge(vector<vector<int>>& grid,int i,int j){
        if(grid[i+1][j+1]!=5) return false;

        unordered_set<int> s;
        for(int m=0;m<3;m++){
            for(int n=0;n<3;n++){
                int tmp=grid[i+m][j+n];
                if(tmp<1 || tmp>9 || s.count(tmp)) return false;
                s.insert(tmp);//判断是否重复和1~9范围内
            }
        }
        for(int m=0;m<3;m++){
            int rsum=0,csum=0;
            for(int n=0;n<3;n++){
                rsum+=grid[i+m][j+n];
                csum+=grid[i+n][j+m];
            }
            if(rsum!=15 || csum!=15) return false;
        }//行和列都是15就够了
        return true;
    }
};
