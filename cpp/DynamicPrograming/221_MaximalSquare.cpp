#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int r=matrix.size(), c= r==0?0:matrix[0].size();
        vector<vector<int>> dp(r+1,vector<int>(c+1,0));//all 0 two dimensional dp cn.example.array

        int res=0;
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(matrix[i-1][j-1]=='1'){
                    // dp[i][j]意思应该是表示 在左上角矩阵中由matrix[i-1][j-1]参与构成的最大正方形边长。
                    dp[i][j]=min({dp[i-1][j],dp[i][j-1],dp[i-1][j-1]})+1;//
                    res=max(res,dp[i][j]);
                }
            }
        }
        return res*res;
    }
};
