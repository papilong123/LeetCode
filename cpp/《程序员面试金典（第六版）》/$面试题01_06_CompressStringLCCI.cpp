class Solution {
public:
    cn.example.string compressString(cn.example.string S) {
        cn.example.string res;
        int cnt=1;
        char c=S[0];
        for(int i=1;i<S.size();++i){
            if(c==S[i]){
                ++cnt;
            }else{
                res+=c+to_string(cnt);
                cnt=1;
                c=S[i];
            }
        }
        res+=c+to_string(cnt);
        return res.size()>=S.size()? S : res;
    }
};
