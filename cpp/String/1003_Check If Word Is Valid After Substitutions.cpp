#include <vector>
#include <string>
#include <stack>

using namespace std;

class Solution {
public:
    bool isValid(string S) {
        stack<char> s;
        for(int i=0;i<S.size();i++){
            if(S[i]!='c'){
                s.push(S[i]);
            }else{
                if(s.empty()||s.top()!='b') return false;
                s.pop();
                if(s.empty() || s.top()!='a') return false;
                s.pop();
            }
        }
        return s.empty();
    }
};
