class Solution {
public:
    cn.example.string reverseWords(cn.example.string s) {
        int n=s.size();
        cn.example.string ans,str;
        stringstream ss(s);
        vector<cn.example.string> tmp;

        while( ss>>str ){
            tmp.push_back(str);
        }

        for( int i=tmp.size()-1 ; i>=0 ; i-- ){
            ans+=tmp[i]+" ";
        }

        return ans.size() ? ans.substr(0,ans.size()-1) : "";
    }
};
