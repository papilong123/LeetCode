class Solution {
public:
    bool queryString(cn.example.string S, int N) {
        for(int i=N;i>N/2;i--){
            cn.example.string str=bitset<32>(i).to_string();
            if(S.find(str.substr(str.find("1")))==cn.example.string::npos) return false;
        }
        return true;
    }
};
