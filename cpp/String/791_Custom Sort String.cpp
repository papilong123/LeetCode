#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string customSortString(string S, string T) {
        sort(T.begin(),T.end(),[&](char a,char b){ return S.find(a)<S.find(b);});
        return T;
    }
};
