#include <algorithm>
#include <string>
#include <vector>
#include <iostream>

using namespace std;

class Solution {
public:
    string findLongestWord(string s, vector<string>& dic) {
        sort(dic.rbegin(), dic.rend(), [](auto&& a, auto&& b){return a.size() < b.size() || a.size() == b.size() && a > b;});
        dic.emplace_back("");
        auto check = [&](string& x){
            int n = s.size(), m = x.size(), l = 0, r = 0;
            while(l < n && r < m) if(s[l++] == x[r]) ++r;
            return r == m;
        };
        return *find_if(begin(dic), end(dic), check);
    }
};

//vector<string> dic = {"ale","apple","monkey","plea"};
//int main(){
//    string res = Solution().findLongestWord("abpcplea", dic);
//    cout << res << endl;
//}
