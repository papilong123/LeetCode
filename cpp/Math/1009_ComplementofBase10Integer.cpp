#include <vector>
#include <cmath>

using namespace std;

class Solution {
public:
    int bitwiseComplement(int N) {
        if(N==0) return 1;
        
        int tmp=log2(N);
        int val= (1<<tmp)-1;
        return (~N) & val;
    }
};
