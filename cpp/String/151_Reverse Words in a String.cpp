#include <vector>
#include <string>
#include <sstream>

using namespace std;

class Solution {
public:
    string reverseWords(string s) {
        int n=s.size();
        string ans,str;
        stringstream ss(s);
        vector<string> tmp;

        while( ss>>str ){
            tmp.push_back(str);
        }

        for( int i=tmp.size()-1 ; i>=0 ; i-- ){
            ans+=tmp[i]+" ";
        }

        return ans.size() ? ans.substr(0,ans.size()-1) : "";
    }
};
