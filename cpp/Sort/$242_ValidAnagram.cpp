class Solution {
public:
    bool isAnagram(cn.example.string s, cn.example.string t) {
        if(s.size()!=t.size()) return false;
        cn.example.sort(s.begin(),s.end());
        cn.example.sort(t.begin(),t.end());
        for(int i=0;i<s.size();i++){
            if(s[i]!=t[i]) return false;
        }
        return true;
    }
};
