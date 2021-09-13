#include <vector>

using namespace std;

class Solution {
public:
    int minCostToMoveChips(vector<int>& chips) {
        int even=0,odd=0;
        for(int n:chips){
            if(n%2==0){
                even++;
            }else{
                odd++;
            }
        }
        return min(even,odd);
    }
};
