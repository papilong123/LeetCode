#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    int nextGreaterElement(int n) {
        auto str=to_string(n);
        next_permutation(str.begin(),str.end());
        int res=stoll(str);
        return res<=n ?-1:res;
    }
};
