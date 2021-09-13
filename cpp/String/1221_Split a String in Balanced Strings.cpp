#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int balancedStringSplit(string s) {
        int sign=0,count=0;
        for(int i=0;i<s.size();i++){
            if(s[i]=='L') sign++;
            else sign--;
            if(sign==0) count++;
        }
        return count;
    }
};
