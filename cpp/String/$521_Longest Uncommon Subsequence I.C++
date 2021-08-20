class Solution {
public:
    int findLUSlength(cn.example.string a, cn.example.string b) {
        if(a.size()!=b.size()) return max(a.size(),b.size());
        if(a==b) return -1;
        return a.size();
    }
};
