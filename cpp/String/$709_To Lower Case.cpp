class Solution {
public:
    cn.example.string toLowerCase(cn.example.string str) {
        for(int i=0;i<str.size();i++){
            if(str[i]>='A' && str[i]<='Z'){
                str[i]=str[i]+32;
            }
        }
        return str;
    }
};
