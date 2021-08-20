class Solution {
public:
    vector<vector<int>> imageSmoother(vector<vector<int>>& M) {
        int r=M.size(),c=M[0].size();
        vector<vector<int>> res(r,vector<int>(c));
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res[i][j]=calculate(M,i,j);
            }
        }
        return res;
    }

    int calculate(vector<vector<int>>& M,int i,int j){
        int side[][2]={{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        int sum=M[i][j];
        int count=1;
        for(int k=0;k<8;k++){
            int row=i+side[k][0];
            int col=j+side[k][1];
            if(row>=0&&row<M.size()&&0<=col&&col<M[0].size()){
                sum+=M[row][col];
                count++;
            }
        }
        return sum/count;
    }
};
