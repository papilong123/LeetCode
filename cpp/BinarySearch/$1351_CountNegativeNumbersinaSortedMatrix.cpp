//二分查找
class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int res=0;
        for(auto v: grid){
            int i=0,j=v.size()-1,pos=-1;
            while(i<=j){
                int mid=i+((j-i)>>1);
                if(v[mid]<0){
                    j=mid-1;
                    pos=mid;
                }else{
                    i=mid+1;
                }
            }
            //若pos=-1,则这一行都是正数，不加任何数
            if(~pos) res+=v.size()-pos;
        }
        
        return res;
    }
};

//暴力
class Solution {
public:
    int countNegatives(vector<vector<int>>& grid) {
        int m=grid.size(),n=grid[0].size();
        int tmp=n;
        int res=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]<0){
                    res+=n-j;
                    break;
                }
            }
        }
        return res;
    }
};
