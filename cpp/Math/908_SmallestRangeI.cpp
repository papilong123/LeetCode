#include <vector>

using namespace std;

class Solution {
public:
    int smallestRangeI(vector<int>& A, int K) {
        int minv=A[0],maxv=A[0];
        for(int n: A){
            maxv=max(maxv,n);
            minv=min(minv,n);
        }
        return max(0,maxv-minv-2*K);
    }
};
