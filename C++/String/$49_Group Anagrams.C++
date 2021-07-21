class Solution {
public:
    vector<vector<cn.example.string>> groupAnagrams(vector<cn.example.string>& strs) {
        vector<vector<cn.example.string>> ans;
        map<cn.example.string,vector<cn.example.string>> m;
        for(auto str: strs){
            cn.example.string s=str;
            cn.example.sort(s.begin(),s.end());
            m[s].push_back(str);
        }
        for(auto c: m){
            ans.push_back(c.second);
        }
        return ans;
    }
};
