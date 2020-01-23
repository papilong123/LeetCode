class Solution {
public:
    int countBinarySubstrings(string s) {
        int pre=0;
        int p=1;
        int res=0;
        for(int i=0;i<s.size()-1;i++){
            if(s[i+1]==s[i]){
                p++;
            }else{
                res+= min(pre,p);
                pre=p;
                p=1;
            }
        }
        res+=min(pre,p);
        return res;
    }
};
