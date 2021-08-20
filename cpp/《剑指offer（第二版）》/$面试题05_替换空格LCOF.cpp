class Solution {
public:
    cn.example.string replaceSpace(cn.example.string s) {
        cn.example.string res;
        for(auto c : s){
            if( c == ' ') res+="%20";
            else res+=c;
        }
        return res;
    }
};
