#include <vector>
using namespace std;

class Solution {
public:
    int numPairsDivisibleBy60(vector<int>& time) {
        int res=0;
        vector<int> c(60);

        for(int t : time){
            res += c[(600-t) % 60];
            c[t % 60]++;
        }
        return res;
    }
};
