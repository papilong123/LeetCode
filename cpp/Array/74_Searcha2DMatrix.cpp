#include <vector>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
      int m=matrix.size();
        if(m==0) return false;
        int n=matrix[0].size();

        //二分查找
        int i=0,j=m*n-1,mid;
        int r,c;
        while(i<=j){
            mid=(i+j)/2;
            r=mid/n;
            c=mid%n;
            if(matrix[r][c]==target) return true;
            else{
                if (target < matrix[r][c]) j = mid - 1;
                else i = mid + 1;
            }
        }
        return false;
    }
};
