class Solution {
public:
    bool CheckPermutation(cn.example.string s1, cn.example.string s2) {
        if(s1.size()!=s2.size()) return false;
        cn.example.sort(s1.begin(),s1.end());
        cn.example.sort(s2.begin(),s2.end());
        int i=0;
        while(i<s1.size()){
            if(s1[i]!=s2[i]) return false;
            i++;
        }
        return true;
    }
};
