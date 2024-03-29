#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    int scoreOfParentheses(string S) {
        int res=0,count=0;
        for(int i=0;i<S.size();i++){
            if(S[i]=='(') count++; else count--;
            if(S[i]==')' && S[i-1]=='(') res+= 1<<count;
        }
        return res;
    }
};
