#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int res=0;
        int r=matrix.size(),c=matrix[0].size();
        vector<vector<int>> m(r,vector<int>(c));
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(i==0 || j==0){
                    m[i][j]=matrix[i][j];
                }else if(matrix[i][j]==0){
                    m[i][j]=0;
                }else{
                    m[i][j]=min({m[i-1][j],m[i][j-1],m[i-1][j-1]})+1;
                }
                res+=m[i][j];
            }
        }
        return res;
    }
};
