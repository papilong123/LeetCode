class Solution {
public:
    cn.example.string customSortString(cn.example.string S, cn.example.string T) {
        cn.example.sort(T.begin(),T.end(),[&](char a,char b){ return S.find(a)<S.find(b);});
        return T;
    }
};
