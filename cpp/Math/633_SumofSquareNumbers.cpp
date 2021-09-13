#include <valarray>

class Solution {
public:
    bool judgeSquareSum(int c) {
        long right=sqrt(c);
        long left=0;
        while(left<=right){
            long tmp=left*left+right*right;
            if(tmp>c){
                right--;
            }else if(tmp<c){
                left++;
            }else{
                return true;
            }
        }
        return false;
    }
};
