#include <vector>
#include <string>
#include <unordered_set>
#include <sstream>

using namespace std;

class Solution {
public:
    string toGoatLatin(string S) {
        string str="ma";
        string ans,tmp;
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
