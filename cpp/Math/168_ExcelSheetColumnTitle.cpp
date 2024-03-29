#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string convertToTitle(int n) {
        string res;
        while(n>0){
            int k=(n-1)%26;
            n=(n-1)/26;
            res.push_back('A'+k);
        }
        reverse(res.begin(),res.end());
        return res;
    }
};
