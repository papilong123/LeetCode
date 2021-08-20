class Solution {
public:
    int romanToInt(cn.example.string s) {
        unordered_map<char,int> m;
        m['M']=1000;
        m['D']=500;
        m['C']=100;
        m['L']=50;
        m['X']=10;
        m['V']=5;
        m['I']=1;

        int neg=0,pos=0;
        for(int i=0;i<s.size();i++){
            if(m[s[i]]<m[s[i+1]]){
                neg+=(-m[s[i]]);
            }else{
                pos+=m[s[i]];
            }
        }
        return neg+pos;
    }
};
