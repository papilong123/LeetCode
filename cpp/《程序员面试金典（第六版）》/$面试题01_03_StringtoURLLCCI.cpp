class Solution {
public:
    cn.example.string replaceSpaces(cn.example.string S, int length) {
        cn.example.string str;
        for(int i=0;i<length;++i){
            if(S[i]==' '){
                str.append("%20");
            }else{
                str.append(1,S[i]);
            }
        }
        return str;
    }
};
