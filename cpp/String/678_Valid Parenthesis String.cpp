#include <vector>
#include <string>

using namespace std;

class Solution {
public:
    bool checkValidString(string s) {
        int count=0;
        for(auto c: s){//判断'('是否比其它字符多
            if(c=='('){
                count++;
            }else{
                count--;
                if(count<0) count=0;
            }
        }
        if(count>0) return false;

        for(int i=s.size()-1;i>=0;i--){//判断')'是否比其它元素多
            if(s[i]==')'){
                count++;
            }else{
                count--;
                if(count<0) count=0;
            }
        }
        return count==0;
    }
};
