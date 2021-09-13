#include <vector>
using namespace std;

class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& A) {
        vector<int> res;
        int t=0;

        for(t=0;t<A.size();t++){
            if(A[t]%2==0){
                res.push_back(A[t]);
            }
        }
        for(t=0;t<A.size();t++){
            if(A[t]%2==1){
                res.push_back(A[t]);
            }
        }
        return res;
    }
};
