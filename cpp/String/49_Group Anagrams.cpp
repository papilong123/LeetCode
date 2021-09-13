#include <vector>
#include <string>
#include <algorithm>
#include <map>

using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        map<string,vector<string>> m;
        for(auto str: strs){
            string s=str;
            sort(s.begin(),s.end());
            m[s].push_back(str);
        }
        for(auto c: m){
            ans.push_back(c.second);
        }
        return ans;
    }
};
