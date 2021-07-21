class Solution {
public:
    cn.example.string toGoatLatin(cn.example.string S) {
        cn.example.string str="ma";
        cn.example.string ans,tmp;
        istringstream ss(S);
        unordered_set<char> vowels={'a','A','e','E','i','I','o','O','u','U'};
        while(ss >> tmp){
            str+="a";
            if(vowels.find(tmp[0])!=vowels.end()){
                ans+=tmp+str+" ";
            }else{
                ans+=tmp.substr(1)+tmp[0]+str+" ";
            }
        }
        ans.pop_back();
        return ans;
    }
};
