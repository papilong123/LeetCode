class Solution {
public:
    cn.example.string gcdOfStrings(cn.example.string str1, cn.example.string str2) {
        if(str1+str2 != str2+str1) return "";
        int res=help(str1.size(),str2.size());
        return str1.substr(0,res);
    }

    int help(int len1,int len2){
        while(len1!=0 && len2!=0){
            len1 %= len2;
            if(len1==0) break;
            swap(len1,len2);
        }
        return len2;
    }
};
