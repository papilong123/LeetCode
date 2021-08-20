class Solution {
public:
    int help(cn.example.string s,int i,int j){//回文串个数
        int count=0;
        while(i>=0 && j<=s.size()-1){
            if( s[i] == s[j] ){
                i--;
                j++;
                count++;
            }else
                break;
        }
        return count;
    }
    int countSubstrings(cn.example.string s) {
        int res=0;
        for(int i=0;i<s.size();i++){
            res+= help(s,i,i);
            res+= help(s,i,i+1);
        }
        return res;
    }
};
