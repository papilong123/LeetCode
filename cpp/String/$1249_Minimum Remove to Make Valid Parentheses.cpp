class Solution {
public:
    cn.example.string minRemoveToMakeValid(cn.example.string s) {
        cn.example.stack<int> stk;
        for(int i=0;i<s.size();i++){
            if(s[i]=='('){
                stk.push(i);
            }else if(s[i]==')'){
                if(!stk.empty()) stk.pop();
                else s[i]='*';
            }
        }
        while(!stk.empty()){
            s[stk.top()]='*';
            stk.pop();
        }
        s.erase( remove(s.begin(),s.end(),'*'), s.end() );
        return s;
    }
};
