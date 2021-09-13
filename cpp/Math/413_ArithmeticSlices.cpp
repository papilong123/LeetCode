#include <vector>

using namespace std;

class Solution {
public:
    int numberOfArithmeticSlices(vector<int>& A) {
        int left=0;
        int res=0;
        int d=0;
        for(int i=1;i<A.size();i++){
            if(A[i]-A[i-1]==d){
                res+=max(i-left-1,0);
            }else{
                d=A[i]-A[i-1];
                left=i-1;
            }
        }
        return res;
    }
};
