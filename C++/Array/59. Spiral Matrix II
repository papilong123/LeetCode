class Solution {
public:
    vector<vector<int>> generateMatrix(int n) {
        vector<vector<int>> res(n,vector(n,0));
        int l=0,r=n-1,u=0,d=n-1;
        int i=1;

        while( i<= n*n){
            for(int j=l;j<=r;j++) res[u][j]=i++;
            u++;
            for(int j=u;j<=d;j++) res[j][r]=i++;
            r--;
            for(int j=r;j>=l;j--) res[d][j]=i++;
            d--;
            for(int j=d;j>=u;j--) res[j][l]=i++;
            l++;
        }
        return res;
    }
};
